import java.util.*;
import java.io.*;
import java.time.LocalDateTime;

class CompanyShares {
    String symbol;
    int shares;
    LocalDateTime lastTransaction;

    public CompanyShares(String symbol, int shares) {
        this.symbol = symbol;
        this.shares = shares;
        this.lastTransaction = LocalDateTime.now();
    }

    public void updateShares(int change) {
        this.shares += change;
        this.lastTransaction = LocalDateTime.now();
    }
}

class StockAccount {
    private List<CompanyShares> portfolio = new ArrayList<>();

    public StockAccount(String filename) {
        loadFromFile(filename);
    }

    private void loadFromFile(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNext()) {
                String symbol = sc.next();
                int shares = sc.nextInt();
                portfolio.add(new CompanyShares(symbol, shares));
            }
        } catch (Exception e) {
            System.out.println("Starting with empty portfolio.");
        }
    }

    public void buy(int amount, String symbol) {
        for (CompanyShares cs : portfolio) {
            if (cs.symbol.equals(symbol)) {
                cs.updateShares(amount);
                return;
            }
        }
        portfolio.add(new CompanyShares(symbol, amount));
    }

    public void sell(int amount, String symbol) {
        for (CompanyShares cs : portfolio) {
            if (cs.symbol.equals(symbol)) {
                if (cs.shares >= amount) {
                    cs.updateShares(-amount);
                } else {
                    System.out.println("Not enough shares");
                }
                return;
            }
        }
        System.out.println("Stock not found");
    }

    public void printReport() {
        System.out.println("\n--- Report ---");
        for (CompanyShares cs : portfolio) {
            System.out.println(cs.symbol + " | Shares: " + cs.shares +
                    " | Last Txn: " + cs.lastTransaction);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StockAccount acc = new StockAccount("stocks.txt");

        acc.buy(10, "AAPL");
        acc.sell(2, "AAPL");

        acc.printReport();
    }
}
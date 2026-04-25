import java.util.*;

class Stock {
    String name;
    int shares;
    double price;

    public Stock(String name, int shares, double price) {
        this.name = name;
        this.shares = shares;
        this.price = price;
    }

    public double getValue() {
        return shares * price;
    }

    public void display() {
        System.out.println("Stock: " + name +
                ", Shares: " + shares +
                ", Price: " + price +
                ", Value: " + getValue());
    }
}

class StockPortfolio {
    List<Stock> stocks = new ArrayList<>();

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double getTotalValue() {
        double total = 0;
        for (Stock s : stocks) {
            total += s.getValue();
        }
        return total;
    }

    public void displayReport() {
        System.out.println("\n--- Stock Report ---");
        for (Stock s : stocks) {
            s.display();
        }
        System.out.println("Total Portfolio Value: " + getTotalValue());
    }
}

public class StockAccountManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StockPortfolio portfolio = new StockPortfolio();

        System.out.print("Enter number of stocks: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Stock Name: ");
            String name = sc.next();

            System.out.print("Enter Number of Shares: ");
            int shares = sc.nextInt();

            System.out.print("Enter Share Price: ");
            double price = sc.nextDouble();

            portfolio.addStock(new Stock(name, shares, price));
        }

        portfolio.displayReport();
    }
}
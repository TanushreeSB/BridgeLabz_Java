class Account {
    private double balance;

    public Account(double balance) {
        if (balance > 0)
            this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
        if (amount > balance) {
            System.out.println("Debit amount exceeded account balance");
        } else {
            balance -= amount;
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acc = new Account(1000);

        System.out.println("Initial Balance: " + acc.getBalance());

        acc.debit(300);
        System.out.println("Balance after debit 300: " + acc.getBalance());

        acc.debit(800); // exceeds balance
        System.out.println("Balance after debit 800: " + acc.getBalance());
    }
}
package exceptionsExample;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) throws ElvisException {
        checkDepositAmount(amount);
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    private void checkDepositAmount(double amount) throws ElvisException {
        if (amount > 100000) {
            throw new ElvisException();
        }
    }
}

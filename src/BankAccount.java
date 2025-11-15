import java.util.ArrayList;

public class BankAccount {

    private double balance;
    private ArrayList<Transaction> history = new ArrayList<>();

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        history.add(new Transaction("Deposit", amount));
        System.out.println("Deposit Successful!");
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            history.add(new Transaction("Withdraw", amount));
            System.out.println("Withdraw Successful!");
        }
    }

    public void transfer(double amount, BankAccount receiver) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            receiver.balance += amount;
            history.add(new Transaction("Transfer Sent", amount));
            receiver.history.add(new Transaction("Transfer Received", amount));
            System.out.println("Transfer Successful!");
        }
    }

    public void showHistory() {
        System.out.println("Transaction History:");
        for (Transaction t : history) {
            System.out.println(t);
        }
    }

    public double getBalance() {
        return balance;
    }
}

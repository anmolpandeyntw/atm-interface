import java.util.Scanner;

public class ATM {

    private User user;
    private BankAccount account;

    public ATM(User user, BankAccount account) {
        this.user = user;
        this.account = account;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        String id = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (!id.equals(user.getUserId()) || !pin.equals(user.getUserPin())) {
            System.out.println("Invalid Login Credentials!");
            return;
        }

        System.out.println("\nLogin Successful!");
        menu();
    }

    private void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> account.showHistory();
                case 2 -> {
                    System.out.print("Enter amount: ");
                    account.withdraw(sc.nextDouble());
                }
                case 3 -> {
                    System.out.print("Enter amount: ");
                    account.deposit(sc.nextDouble());
                }
                case 4 -> {
                    System.out.print("Enter recipient amount: ");
                    double amt = sc.nextDouble();
                    BankAccount receiver = new BankAccount(0);
                    account.transfer(amt, receiver);
                }
                case 5 -> {
                    System.out.println("Thank you for using ATM!");
                    return;
                }
                default -> System.out.println("Invalid Option!");
            }
        }
    }
}

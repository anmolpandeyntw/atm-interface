public class Main {
    public static void main(String[] args) {

        User user = new User("12345", "6789");
        BankAccount account = new BankAccount(5000);

        ATM atm = new ATM(user, account);
        atm.start();
    }
}

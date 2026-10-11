import java.util.ArrayList;
import java.util.List;

public class BankDemo {

    public static void main(String[] args) {

        // Create a list of Account references
        List<Account> accounts = new ArrayList<>();

        // Add SavingsAccount and CurrentAccount objects
        accounts.add(new SavingsAccount("SAV001", 1500.00));
        accounts.add(new SavingsAccount("SAV002", 800.00));

        accounts.add(new CurrentAccount("CUR001", 300.00));
        accounts.add(new CurrentAccount("CUR002", 200.00));


        System.out.println("========== BANK DEMO ==========");


        // Polymorphic loop
        for (Account account : accounts) {

            System.out.println("\nAccount: " + account.accountNumber);

            System.out.println("Current balance: "
                    + account.getBalance());

            System.out.println("\nAttempting withdrawal...");

            // Polymorphic method call
            account.withdraw(1100.00);

            System.out.println("Balance after withdrawal: "
                    + account.getBalance());

            System.out.println("\nRunning month-end processing...");

            // Polymorphic method call
            account.endOfMonth();

            System.out.println("Balance after month-end: "
                    + account.getBalance());
        }


        // ==============================
        // EDGE CASE 1
        // ==============================

        System.out.println("\n========== EDGE CASE 1 ==========");

        Account savings = new SavingsAccount("SAV003", 700.00);

        System.out.println("Savings balance: "
                + savings.getBalance());

        System.out.println("Attempting to withdraw 300...");

        savings.withdraw(300.00);

        System.out.println("Final balance: "
                + savings.getBalance());


        // ==============================
        // EDGE CASE 2
        // ==============================

        System.out.println("\n========== EDGE CASE 2 ==========");

        Account current = new CurrentAccount("CUR003", 200.00);

        System.out.println("Current balance: "
                + current.getBalance());

        System.out.println("Attempting to withdraw 1000...");

        current.withdraw(1000.00);

        System.out.println("Final balance: "
                + current.getBalance());
    }
}

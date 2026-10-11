public class CurrentAccount extends Account {

    // Fixed overdraft limit
    private static final double OVERDRAFT_LIMIT = 1000.00;

    // Monthly maintenance fee
    private static final double MAINTENANCE_FEE = 50.00;

    // Constructor
    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    // Override withdraw
    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be positive.");
        }
        else if (balance - amount < -OVERDRAFT_LIMIT) {

            System.out.println(
                    "Current withdrawal rejected: overdraft limit exceeded."
            );

        }
        else {
            balance -= amount;

            System.out.println(
                    "Current withdrawal successful: " + amount
            );
        }
    }

    // Override endOfMonth
    @Override
    public void endOfMonth() {

        balance -= MAINTENANCE_FEE;

        System.out.println(
                "Monthly maintenance fee charged: " + MAINTENANCE_FEE
        );
    }
}

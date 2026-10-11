public class SavingsAccount extends Account {

    // Fixed minimum balance
    private static final double MINIMUM_BALANCE = 500.00;

    // Interest rate
    private static final double INTEREST_RATE = 0.02;

    // Constructor
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    // Override withdraw
    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be positive.");
        }
        else if (balance - amount < MINIMUM_BALANCE) {

            System.out.println(
                    "Savings withdrawal rejected: balance cannot fall below "
                            + MINIMUM_BALANCE
            );

        }
        else {
            balance -= amount;

            System.out.println(
                    "Savings withdrawal successful: " + amount
            );
        }
    }

    // Override endOfMonth
    @Override
    public void endOfMonth() {

        double interest = balance * INTEREST_RATE;

        balance += interest;

        System.out.println(
                "Savings interest added: " + interest
        );
    }
}

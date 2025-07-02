package banking;

public class SavingAccount extends Account {
    public SavingAccount(String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void debit(double amount) {
        if (balance() - amount < 1000) {
            System.out.println("withdraw failed. Minimum balance 1000 needed");
        } else {
            balance -= amount;
            System.out.println("Debited ");
        }
    }


    @Override
    public void getInterestRate() {
        return 0.025; // 2.5% interest rate
    }
}

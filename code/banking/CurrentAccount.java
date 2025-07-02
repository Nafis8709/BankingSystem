package banking;

public class CurrentAccount extends Account {
    public CurrentAccount(String id, String name, double balance) {
        super(id, name, balance);
    }
    @Override
    public void debit(double amount) {
        if (amount > balance) {
            System.out.println("Amount exceeded balance.");
        } else {
            balance -= amount;
            System.out.println("Debited ");
        }
    }
    @Override
    public double getInterest() {
        return 0;
    }
}

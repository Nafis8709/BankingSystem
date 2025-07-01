package banking;

public class CurrentAccount extends Account {
    public CurrentAccount(String id, String name, double balance) {
        super(id, name, (int)balance);
    }
    @Override
    public void credit(double amount) {
        super.credit(amount);
    }

    @Override
    public void debit(double amount) {
        if (amount > getBalance()) {
            System.out.println("Amount exceeded balance.");
        } else {
            super.debit((int) amount);
        }
    }

}

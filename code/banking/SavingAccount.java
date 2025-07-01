package banking;

public class SavingAccount extends Account {
    public SavingAccount(String id, String name, double balance) {
        super(id, name, (int) balance);
    }

    @Override
    public void debit(double amount) {
        if (getBalance() - amount < 1000) {
            System.out.println("withdraw failed. Minimum balance 1000 needed");
        } else {
            super.debit(amount);
        }
    }

    @Override
    public void credit(double amount) {
        super.credit(amount);
        addInterest();
    }

    public void addInterest() {
        double interest = getBalance() * 0.025;
        credit(interest);
        System.out.println("Interest of " + interest + " added.");
    }
}

package banking;

public class DepositPremiumAccount extends Account {
    private int installment = 0;

    public DepositPremiumAccount(String id, String name, double balance) {
        super(id, name, (int)balance);
    }

    @Override
    public void credit(double amount) {
        super.credit((int) amount);
        installment++;
        addInterest();
    }

    @Override
    public void debit(double amount) {
        if (installment < 5) {
            System.out.println("Cannot withdraw before 5 installments.");
        } else {
            super.debit((int) amount);
        }
    }

    public void addInterest() {
        double interest = getBalance() * 0.07;
        credit(interest);
        System.out.println("Interest of " + interest + " added.");
    }
}


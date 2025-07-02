package banking;

public class DepositPremiumAccount extends Account {
    private int installment = 0;
    private static final int totalInstallments = 5;

    public DepositPremiumAccount(String id, String name, double balance) {

        super(id, name, balance);
    }

    @Override
    public void credit(double amount) {
        super.credit(amount);
        if (installment < totalInstallments) {
            installment++;
            System.out.println("Installment " + installment + " credited.");
        }
    }

    @Override
    public void debit(double amount) {
        if (installment < totalInstallments) {
            System.out.println("Cannot withdraw before 5 installments.");
        } else if(amount > balance){
            System.out.println("Amount exceeded balance.");
        } else {
            balance-=amount;
            System.out.println("Debited ");
        }
    }

    @Override
    public double getInterestRate(){
        return 0.07;
    }
}


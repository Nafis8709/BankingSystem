package banking;

public abstract class Account {
    private String id;
    private String name;
    private double balance;


    public Account(String id,String name,double balance){
        this.id=id;
        this.name=name;
        this.balance=balance;
    }

    /*Account(String id,String name,int balance){
        this.id=id;
        this.name=name;
        this.balance=balance;
    }*/

    public String getID(){
        return id;
    }

    /*public String getName(){
        return name;
    }*/

    public double getBalance(){
        return balance;
    }
    public abstract void debit (double amount);
    public void credit (double amount){
        balance+=amount;
    }
    public abstract double getInterest();

    public void transferTo(Account receiver, double amount){
        if(this instanceof DepositPremiumAccount){
            System.out.println("Cannot transfer from Deposit Premium Account before 5 installments.");
        }
            this.debit(amount);
            receiver.credit(amount);
            System.out.println("Transferred ");
        }
}


    /*public int credit(int amount){
        this.balance+=amount;
        return balance;
    }

    public int debit(int amount){
        if(amount<=this.balance){
            this.balance-=amount;
        }
        else{
            System.out.println("Amount exceeded balance");
        }

        return balance;
    }


    public int transferTo(Account a, int amount){
        if(this.balance>=amount) {
            a.credit(amount);
            this.debit(amount);
        }
        else{
            System.out.println("Amount exceeded balance");
        }

        return amount;
    }

    public void addInterest() {
    }

    public String toString(){
        return "Account id: "+ this.id+" \nAccount name: "+this.name+" \nbalance: "+this.balance;
    }

    public void credit(double amount) {
    }

    public void debit(double amount) {
    }*/
}

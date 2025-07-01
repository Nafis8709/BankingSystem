package banking;

public class Account {
    private String id;
    private String name;
    private int balance;


    Account(String id,String name){
        this.id=id;
        this.name=name;
        this.balance=0;
    }

    Account(String id,String name,int balance){
        this.id=id;
        this.name=name;
        this.balance=balance;
    }

    public String getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getBalance(){
        return balance;
    }

    public int credit(int amount){
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
    }
}

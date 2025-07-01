package banking;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        // Add initial accounts if needed
        accounts.add(new SavingAccount("1620", "sinha", 0));
        accounts.add(new CurrentAccount("1619", "rashik", 0));
        accounts.add(new DepositPremiumAccount("1621", "nafis", 0));

        Scanner sc = new Scanner(System.in);

        int choice;

        while (true) {
            System.out.println("------MENU-----");
            System.out.println("1.Create new account");
            System.out.println("2.DEBIT");
            System.out.println("3.CREDIT");
            System.out.println("4.Transfer Money");
            System.out.println("5.Check Balance");
            System.out.println("6.exit\n");
            System.out.println("Enter your choice : ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("name:");
                    String newName = sc.nextLine();

                    System.out.println("ID");
                    String newID = sc.nextLine();

                    System.out.println("Select account type:");
                    System.out.println("1. Saving Account");
                    System.out.println("2. Current Account");
                    System.out.println("3. Deposit Account");
                    int accType = sc.nextInt();
                    sc.nextLine();
                    Account newAccount = null;
                    switch (accType) {
                        case 1:
                            newAccount = new SavingAccount(newID, newName, 0);
                            System.out.println("Saving Account created.");
                            break;
                        case 2:
                            newAccount = new CurrentAccount(newID, newName, 0);
                            System.out.println("Current Account created.");
                            break;
                        case 3:
                            newAccount = new DepositPremiumAccount(newID, newName, 0);
                            System.out.println("Deposit Account created.");
                            break;
                        default:
                            System.out.println("Invalid account type");
                            break;
                    }
                    if (newAccount != null) {
                        accounts.add(newAccount);
                    }
                    break;
                case 2:
                    System.out.println("Enter the amount : ");
                    int newAmount = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter account number :");
                    String debitID = sc.nextLine();
                    boolean foundDebit = false;
                    for (Account acc : accounts) {
                        if (acc.getID().equals(debitID)) {
                            acc.debit(newAmount);
                            foundDebit = true;
                            break;
                        }
                    }
                    if (!foundDebit) {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter account number :");
                    String creditID = sc.nextLine();

                    System.out.println("Enter the amount : ");
                    newAmount = sc.nextInt();
                    sc.nextLine();
                    boolean foundCredit = false;
                    for (Account acc : accounts) {
                        if (acc.getID().equals(creditID)) {
                            acc.credit(newAmount);
                            foundCredit = true;
                            break;
                        }
                    }
                    if (!foundCredit) {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter sender account number:");
                    String senderID = sc.nextLine();
                    System.out.println("Enter receiver account number :");
                    String receiverID = sc.nextLine();
                    System.out.println("Enter amount :");
                    newAmount = sc.nextInt();
                    sc.nextLine();
                    Account sender = null, receiver = null;
                    for (Account acc : accounts) {
                        if (acc.getID().equals(senderID)) sender = acc;
                        if (acc.getID().equals(receiverID)) receiver = acc;
                    }
                    if (sender != null && receiver != null) {
                        sender.transferTo(receiver, newAmount);
                    } else {
                        System.out.println("Sender or receiver account not found.");
                    }
                    break;
                case 5:
                    System.out.println("Enter account number:");
                    String balID = sc.nextLine();
                    boolean foundBal = false;
                    for (Account acc : accounts) {
                        if (acc.getID().equals(balID)) {
                            System.out.println("Balance: " + acc.getBalance());
                            foundBal = true;
                            break;
                        }
                    }
                    if (!foundBal) {
                        System.out.println("Account not found.");
                    }
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}


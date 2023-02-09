import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name, password and amount to create your account in SBI: ");
        String name = sc.next();
        String password = sc.next();
        int amount = sc.nextInt();
//       Create account for SBI Bank
        BankInterface sbi = new SBIAccount(name,password,amount);
        System.out.println("Your SBI account has successfully created");
        System.out.println("Your Name: "+name);
        System.out.println("Account Number: "+sbi.getAccountNo());
        System.out.println("Available Balance: "+sbi.getBalance());

//      cash Deposite
        System.out.println("Enter amount you want to deposit: ");
        int cash = sc.nextInt();
        System.out.println(sbi.depositMoney(cash));
        System.out.println("Total balance: "+sbi.getBalance());

//      cash Withdraw
        System.out.println("Enter amount you wants to withdraw:");
        int withdraw = sc.nextInt();
        System.out.println("Enter your password:");
        String verifyPassword = sc.next();
        System.out.println(sbi.withdraw(withdraw,verifyPassword));

//        Calculate interest
        System.out.println("Enter time duration in (year) for interest:");
        int time = sc.nextInt();
        System.out.println("Your interest for "+time+" year "+sbi.calculateIntrest(time));
    }
}
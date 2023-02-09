import java.util.UUID;
public class SBIAccount implements BankInterface{
    private String name;
    private String accountNo;
    private String password;
    private int balance;
    private double rateOfIntrest;

    public SBIAccount(String name, String password, int balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.rateOfIntrest = 6.6;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getRateOfIntrest() {
        return rateOfIntrest;
    }

    public void setRateOfIntrest(double rateOfIntrest) {
        this.rateOfIntrest = rateOfIntrest;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public String depositMoney(int amount) {
        this.balance += amount;
        return "You have successfully deposited: "+amount;
    }

    @Override
    public String withdraw(int amount, String enterPassword) {
        if(enterPassword.equals(this.password)){
            if(balance < amount){
                return "Insufficient balance, available balance is: "+balance;
            }else{
                balance -= amount;
                return "You withdrawn money "+amount+" and your available balance is: "+this.balance;
            }
        }else{
            return "Incorrect Password";
        }
    }

    @Override
    public double calculateIntrest(int time) {
        return (balance*rateOfIntrest*time)/100.0;
    }
}

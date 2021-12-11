import java.util.Random;

public class BankAccount {
    private double checkingBalance, savingsBalance;
    private String name;
    private int accntNumber;
    private static int numOfAccounts;
    private static double totalFunds=0.0, totalChecking=0.0, totalSavings=0.0;

    public BankAccount(double checkingBalance, double savingsBalance, String name){
        this.checkingBalance=checkingBalance;
        this.savingsBalance=savingsBalance;
        this.name=name;
        this.accntNumber=setAccntNumber();
        numOfAccounts++;
        totalChecking+=checkingBalance;
        totalSavings+=savingsBalance;
        totalFunds+=checkingBalance+savingsBalance;
        getTotalNumberOfAccounts();
        getTotalFunds();
    }
    private int setAccntNumber(){
        Random rand = new Random();
        accntNumber=rand.nextInt(1000000001);
        return accntNumber;
    }
    private void getTotalNumberOfAccounts(){
        System.out.printf("Total number of accounts created: %d\n",numOfAccounts);
    }
    private void getTotalFunds(){
        System.out.printf("Total funds in all accounts: %,.2f\n",totalFunds);
        System.out.printf("Total funds in all checking accounts: %,.2f\n",totalChecking);
        System.out.printf("Total funds in all savings accounts: %,.2f\n",totalSavings);
    }
    public void deposit(double deposit, String whichBalance){
        totalFunds+=deposit;
        if(whichBalance=="1") {
            totalChecking+=deposit;
            this.checkingBalance += deposit;
            System.out.println(getCheckingBalance());
        }else if(whichBalance=="2"){
            totalSavings+=deposit;
            this.savingsBalance += deposit;
            System.out.println(getSavingsBalance());
        }
    }
    public void withdrawal(double withdraw, String whichBalance){
        if(whichBalance=="1") {
            if((this.checkingBalance-withdraw)<0){
                System.out.println("Insufficient Funds.");
            }else {
                totalFunds-=withdraw;
                totalChecking -= withdraw;
                this.checkingBalance -= withdraw;
                System.out.println(getCheckingBalance());
            }
        }else if(whichBalance=="2"){
            if((this.checkingBalance-withdraw)<0){
                System.out.println("Insufficient Funds.");
            }else {
                totalFunds-=withdraw;
                totalSavings -= withdraw;
                this.savingsBalance -= withdraw;
                System.out.println(getSavingsBalance());
            }
        }
    }
    public void setCheckingBalance(Double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }
    public void setSavingsBalance(Double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getCheckingBalance() {
        return checkingBalance;
    }
    public Double getSavingsBalance() {
        return savingsBalance;
    }

    public int getAccntNumber() {
        return accntNumber;
    }

    public String getName(){
        return this.name;
    }
}

public class BankAccount {
    private double checkingBalance, savingsBalance;
    private String name;
    private static int numOfAccounts;
    private static double totalFunds=0.0;
    public BankAccount(double checkingBalance, double savingsBalance){
        this.checkingBalance=checkingBalance;
        this.savingsBalance=savingsBalance;
        numOfAccounts++;
        totalFunds+=checkingBalance+savingsBalance;
        getTotalNumberOfAccounts();
        getTotalFunds();
    }
    private void totalAccounts(){
        System.out.printf("Total number of accounts: %d\n", numOfAccounts);
    }

    public void deposit(double deposit, int whichBalance){
        totalFunds+=deposit;
        if(whichBalance==1) {
            this.checkingBalance += deposit;
            System.out.println(getCheckingBalance());
        }else if(whichBalance==2){
            this.savingsBalance += deposit;
            System.out.println(getSavingsBalance());
        }
        getCheckingBalance();
    }
    public void withdrawal(double withdraw, int whichBalance){
        totalFunds-=withdraw;
        if(whichBalance==1) {
            this.checkingBalance -= withdraw;
            System.out.println(getCheckingBalance());

        }else if(whichBalance==2){
            this.savingsBalance -= withdraw;
            System.out.println(getSavingsBalance());
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
    private void getTotalNumberOfAccounts(){
        System.out.println(numOfAccounts);
    }
    private void getTotalFunds(){
        System.out.println(totalFunds);
    }
}

import java.util.Scanner;
public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount sacha = new BankAccount(300.00, 50.00, "Sacha");
        BankAccount moira = new BankAccount(500.00, 6.00, "Moira");
        BankAccount carys = new BankAccount(1000.00, 20000.00, "Carys");
        BankAccount evelyn = new BankAccount(8000.00, 3000.00, "Evelyn");
        System.out.printf("%s Saving's account balance is: %,.2f\n",sacha.getName(), sacha.getSavingsBalance());
        System.out.printf("Accnt #: %d Saving's account balance is: %,.2f\n",moira.getAccntNumber(), moira.getSavingsBalance());

//        createAccount();
    }
    public static void createAccount(){
        Scanner scanner = new Scanner(System.in);
        boolean anotherTransaction = true;
        BankAccount accnt1 = new BankAccount(0.00, 0.00, "");

        System.out.print("Please enter a name for your account: ");
        String name = scanner.next();
        accnt1.setName(name);

        while(anotherTransaction) {
            System.out.println("Please select one:");
            System.out.println("1. Checking ");
            System.out.println("2. Savings ");

            String whichBalance = scanner.next();
            if (whichBalance.equals("1")) {
                System.out.println("1. Deposit");
                System.out.println("2. Withdrawal");

                if (scanner.next().equals("1")) {
                    System.out.print("Enter Amount to Deposit: ");
                    accnt1.deposit(scanner.nextDouble(), whichBalance);
                }else if (scanner.nextInt() == 2) {
                    System.out.print("Enter Amount to Withdraw: ");
                    accnt1.withdrawal(scanner.nextDouble(), whichBalance);
                }
            } else if (scanner.next().equals("2")) {
                System.out.println("1. Deposit");
                System.out.println("2. Withdrawal");

                if (scanner.next().equals("1")) {
                    System.out.print("Enter Amount to Deposit: ");
                    accnt1.deposit(scanner.nextDouble(), whichBalance);
                } else if (scanner.next().equals("2")) {
                    System.out.print("Enter Amount to Withdraw: ");
                    accnt1.withdrawal(scanner.nextDouble(), whichBalance);
                }
            }
            scanner.nextLine();
            System.out.println("Another Transaction?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            if (scanner.nextInt() == 2) {
                anotherTransaction = false;
            }
        }
        scanner.close();
    }
}

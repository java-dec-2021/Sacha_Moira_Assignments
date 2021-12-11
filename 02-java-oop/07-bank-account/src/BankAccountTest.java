import java.util.Scanner;
public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount sacha = new BankAccount(300.00, 50.00);
        BankAccount moira = new BankAccount(500.00, 6.00);
        BankAccount carys = new BankAccount(1000.00, 20000.00);
        BankAccount evelyn = new BankAccount(8000.00, 3000.00);
        System.out.println(sacha.getSavingsBalance());
//        createAccount();
    }
    public static void createAccount(){
        Scanner scanner = new Scanner(System.in);
        boolean anotherTransaction = true;
        BankAccount accnt1 = new BankAccount(0.00, 0.00);

        System.out.print("Please enter a name for your account: ");
        String name = scanner.next();
        accnt1.setName(name);

        while(anotherTransaction) {
//            scanner.nextLine();
            System.out.println("Please select one:");
            System.out.println("1. Checking ");
            System.out.println("2. Savings ");

            int whichBalance = scanner.nextInt();

            if (whichBalance == 1) {
//                scanner.nextLine();
                System.out.println("1. Deposit");
                System.out.println("2. Withdrawal");

                if (scanner.nextInt() == 1) {
//                    scanner.nextLine();
                    System.out.print("Enter Amount to Deposit: ");
                    accnt1.deposit(scanner.nextDouble(), whichBalance);
                }else if (scanner.nextInt() == 2) {
                    System.out.print("Enter Amount to Withdraw: ");
                    accnt1.withdrawal(scanner.nextDouble(), whichBalance);
                }
            } else if (scanner.nextInt() == 2) {
                System.out.println("1. Deposit");
                System.out.println("2. Withdrawal");

                if (scanner.nextInt() == 1) {
//                    scanner.nextLine();
                    System.out.print("Enter Amount to Deposit: ");
                    accnt1.deposit(scanner.nextDouble(), whichBalance);
                } else if (scanner.nextInt() == 2) {
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

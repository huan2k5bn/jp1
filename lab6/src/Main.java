import Entity.CurrentAccount;
import Entity.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        double ibal,damt,wamt;
        ibal = 1000.00;
        SavingsAccount savingsAccount = new SavingsAccount("SA001", ibal);
        System.out.println("Savings A/c: Initial Balance: $" + ibal);

        damt = 500.00;
        savingsAccount.deposit(damt);

        wamt = 250.00;
        savingsAccount.withdraw(wamt);

        wamt = 1600.00;
        System.out.println("\n Try to Withdraw: $" + wamt);
        savingsAccount.withdraw(wamt);
        System.out.println();

        ibal = 5000.00;
        CurrentAccount currentAccount = new CurrentAccount("CA001", ibal);
        System.out.println("Current A/c: Initial Balance: $" + ibal);

        damt = 500.00;
        currentAccount.deposit(1000.0);

        wamt = 1250.00;
        currentAccount.withdraw(3000.00);
        wamt = 6000.00;
        System.out.println("\n Try to Withdraw: $" + wamt);
        savingsAccount.withdraw(wamt);

    }
}
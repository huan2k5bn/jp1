package Entity;

public class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Deposit of $" + amount + "successful. Current balance: $" + getBalance());
    }

    @Override
    public void withdraw(double amount) {
        if(getBalance() >= amount){
            setBalance(getBalance() - amount);
            System.out.println("Withdraw of $" + amount + "successful. Current balance: $" + getBalance());
        }else{
            System.out.println("Insufficient funds. Withdrawal failed");
        }
    }
}

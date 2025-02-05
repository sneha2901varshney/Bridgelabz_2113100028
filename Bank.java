
import java.util.* ;

public class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name)
    {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void openAccount(Customer customer, double initialDeposit)
    {
        BankAccount newAccount = new BankAccount(this, initialDeposit);
        customer.addAccount(newAccount);
        if (!customers.contains(customer))
        {
            customers.add(customer);
        }
        System.out.println("Account opened for " + customer.getName() + " at " + this.name);

    }
        public static void main(String[] args)
        {
        Bank bank1 = new Bank("ABC Bank");
        Customer customer1 = new Customer("Abhii");

        bank1.openAccount(customer1, 1000.0);
        customer1.viewBalance();
        }
   
}

class Customer {
    private String name;
    private List<BankAccount> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Account balances for " + name + ":");
        for (BankAccount account : accounts) {
            System.out.println("Bank: " + account.getBank().getName() + " | Balance: $" + account.getBalance());
        }
    }
}

class BankAccount {
    private Bank bank;
    private double balance;

    public BankAccount(Bank bank, double balance) {
        this.bank = bank;
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }
}




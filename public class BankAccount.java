public class BankAccount
{
   private static String bankName = "ABC Bank " ;
   private final String accountNumber ;
   private static int totalAccounts = 0;
   private String accountHolderName ;

   public static int getTotalAccounts() 
   {
    return totalAccounts ;
   }

 BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

public void displayAccountDetails()
    {
        if (this instanceof BankAccount) 
        {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + this.accountHolderName);
            System.out.println("Account Number: " + this.accountNumber);
          
        }
    }
    
    public static void main(String[] args) 
    {
        BankAccount bk1 = new BankAccount("Akansha", "55665456");
        BankAccount bk2 = new BankAccount("Priya", "9978676");

        bk1.displayAccountDetails();
        bk2.displayAccountDetails();

        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}


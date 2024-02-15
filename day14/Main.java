package day14;
import java.util.Scanner;
public class Main
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        BankingSystem bn= new BankingSystem();
        System.out.println("Hiii Welcome to our Bank");

         while(true)
         {
             System.out.println("Select an option");
             System.out.println("0. Exit");
             System.out.println("1. Add Account");
             System.out.println("2. Deposit Amount");
             System.out.println("3. Withdrawl Amount");
             System.out.println("4. Transfer Amount");
             System.out.println("5. See Transaction History");
             int n=sc.nextInt();
             if(n==0)
             {
                 System.out.println("Exiting");
                 break;
             }
             switch(n)
             {
                 case 1:
                 {
                     try
                     {
                         BankAccount newuser=addAccount();
                         bn.addAccount(newuser);
                     }
                     catch (BankException.InvalidAccountException e)
                     {
                         System.out.println(e);
                     }
                     catch (BankException.NegativeAmountException e )
                     {
                         System.out.println(e);
                     }
                     catch (BankException e) {
                         e.printStackTrace();
                     }
                     break;
                 }
                 case 2:
                 {
                     try
                     {
                         bn.deposit();
                     }
                     catch (BankException.NegativeAmountException e)
                     {
                         System.out.println(e);
                     }
                     catch (BankException.InvalidAccountException e)
                     {
                         System.out.println(e);
                     }
                     catch (BankException.NonExistenceAccountException e)
                     {
                         System.out.println(e);
                     }
                     catch (BankException e) {
                         e.printStackTrace();
                     }

                     break;
                 }
                 case 3:
                 {
                     try
                     {
                         bn.withdrawl();
                     }
                     catch (BankException.NegativeAmountException e)
                     {
                         System.out.println(e);
                     }
                     catch (BankException.InvalidAccountException e)
                     {
                         System.out.println(e);
                     }
                     catch (BankException.NonExistenceAccountException e)
                     {
                         System.out.println(e);
                     }
                     catch (BankException.InsufficientFundsException e)
                     {
                         System.out.println(e);
                     }
                     catch (BankException e) {
                         e.printStackTrace();
                     }


                     break;
                 }
                 case 4:
                 {
                     try
                     {
                         bn.tranfer();
                     }
                     catch (BankException.NegativeAmountException e)
                     {
                         System.out.println(e);
                     }
                     catch (BankException.InvalidAccountException e)
                     {
                         System.out.println(e);
                     }
                     catch (BankException.NonExistenceAccountException e)
                     {
                         System.out.println(e);
                     }
                     catch (BankException.InsufficientFundsException e)
                     {
                         System.out.println(e);
                     }
                     catch (BankException e) {
                         e.printStackTrace();
                     }
                     break;
                 }
                 case 5:
                 {
                     try
                     {
                         bn.showTransacton();
                     }
                     catch (BankException.InvalidAccountException e)
                     {
                         System.out.println(e);
                     }
                     catch (BankException.NonExistenceAccountException e)
                     {
                         System.out.println(e);
                     }

                     catch (BankException e) {
                         e.printStackTrace();
                     }

                    break;
                 }
                 default:
                     System.out.println("You have entered an invalid option");
             }
         }
    }
    static public BankAccount addAccount() throws BankException
    {
        System.out.println("Add the Account number of the User");
        String accountNumber=sc.next();
        if(accountNumber.length()<10 || accountNumber.length()>10)
        {
            throw new BankException.InvalidAccountException();
        }
        System.out.println("How much amount do you want to deposit?");
        double balance=sc.nextDouble();
        if(balance<0)
        {
            throw new BankException.NegativeAmountException();
        }
        BankAccount newuser= new BankAccount(accountNumber,balance);
        return newuser;
    }
}

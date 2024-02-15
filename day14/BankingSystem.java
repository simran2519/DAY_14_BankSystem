package day14;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingSystem
{
    int i=0;
    Scanner sc = new Scanner(System.in);
    List<BankAccount> bankAccountList;            //List to store the users of bank
    BankingSystem()
    {
        bankAccountList=new ArrayList<>();
    }
    //add Bank Accounts
    public void addAccount(BankAccount newaccount)
    {
        bankAccountList.add(newaccount);
        System.out.println("Account is added successfully!");
    }
    //Deposit
    public void deposit() throws BankException   //Throwing the BankException class where all the other classes are present
    {
        sc.nextLine();
        System.out.println("Enter the Bank Account");
        String accountNumber=sc.next();
        if(accountNumber.length()<10 || accountNumber.length()>10)      // for invalid accounts
        {
            throw new BankException.InvalidAccountException();
        }
        System.out.println("Enter how much amount you want to deposit:");
        double amount=sc.nextDouble();
        if(amount<0)
        {
            throw new BankException.NegativeAmountException();             //for negative amounts
        }
        BankAccount deposittoAccount=null;
        for(BankAccount bankAccount: bankAccountList)
        {
            if(accountNumber.equals(bankAccount.getAccountNumber()))      //Finding the account that in which account to deposit the money
            {
                deposittoAccount= bankAccount;
                break;
            }
        }
        if(deposittoAccount==null)
        {
            throw new BankException.NonExistenceAccountException();       //for invalid accounts
        }
        else
        {
            double newAmount=deposittoAccount.getBalance()+amount;        //Adding the amount
            deposittoAccount.setBalance(newAmount);                       //set the value of new amount
            System.out.println("Deposit is done");
            System.out.println("New Amount is : "+ newAmount);
            i++;
            Transaction tr= new Transaction(i,"Deposit",amount);
            deposittoAccount.transactionList.add(tr);
        }
    }

    //Withdrawl
    public void withdrawl() throws BankException
    {
        sc.nextLine();
        System.out.println("Enter the Bank Account");
        String accountNumber=sc.next();
        if(accountNumber.length()<10 || accountNumber.length()>10)        //Finding the account that in which account to withdrawl the money
        {
            throw new BankException.InvalidAccountException();
        }
        System.out.println("Enter how much amount you want to withdrawl");
        double amount=sc.nextDouble();
        if(amount<0)
        {
            throw new BankException.NegativeAmountException();     //Exception for Negative Amounts
        }
        BankAccount withdrawltoAccount=null;
        for(BankAccount bankAccount: bankAccountList)
        {
            if(accountNumber.equals(bankAccount.getAccountNumber()))   //For invalid account
            {
                withdrawltoAccount= bankAccount;
                break;
            }
        }
        if(withdrawltoAccount==null)
        {
            throw new BankException.NonExistenceAccountException();   //Finding the account that in which account to withdrwal the money
        }
        else
        {
            double newAmount=withdrawltoAccount.getBalance()-amount;
            if(newAmount<0)
            {
                throw new BankException.InsufficientFundsException();
            }
            withdrawltoAccount.setBalance(newAmount);
            System.out.println("Withdrawl is done");
            System.out.println("New Amount is : "+ newAmount);
            i++;
            Transaction tr= new Transaction(i,"Withdrawl",amount);
            withdrawltoAccount.transactionList.add(tr);
        }
    }

    //Transfer Amount
    public void tranfer() throws BankException
    {
        System.out.println("Enter your account no.");
        String accountNumber=sc.next();
        if(accountNumber.length()<10 || accountNumber.length()>10)
        {
            throw new BankException.InvalidAccountException();
        }
        BankAccount fromTransfer=null;
        for(BankAccount bankAccount: bankAccountList)         //sender
        {
            if(bankAccount.getAccountNumber().equals(accountNumber))
            {
                fromTransfer=bankAccount;
                break;
            }
        }
        if(fromTransfer==null)
        {
            throw  new BankException.NonExistenceAccountException();
        }
        else
        {
            System.out.println("Enter the account number where you want to tranfer money");
            String accountNumber2=sc.next();
            if(accountNumber2.length()<10 || accountNumber2.length()>10)
            {
                throw new BankException.InvalidAccountException();
            }
            BankAccount toTransfer=null;
            for(BankAccount bankAccount2:bankAccountList)
            {
                if(bankAccount2.getAccountNumber().equals(accountNumber2))
                {
                    toTransfer=bankAccount2;
                    break;
                }
            }
            if(toTransfer==null)
            {
                throw new BankException.NonExistenceAccountException();
            }
            else
            {
                System.out.println("Enter how much amount do you want to tranfer");
                double amount=sc.nextDouble();
                if(amount<0)
                {
                    throw new BankException.NegativeAmountException();
                }
                double newamount=fromTransfer.getBalance()-amount;
                if(newamount<0)
                {
                    throw new BankException.InsufficientFundsException();
                }
                else
                {
                    fromTransfer.setBalance(newamount);
                    toTransfer.setBalance(toTransfer.getBalance()+amount);
                    System.out.println("The sender's total amount:" + fromTransfer.getBalance());
                    System.out.println("The receiver's total amount:"+ toTransfer.getBalance());
                    i++;
                    Transaction tr= new Transaction(i,"Amount Sent",amount);
                    fromTransfer.transactionList.add(tr);
                    Transaction tr1= new Transaction(i,"Amount Received",amount);
                    toTransfer.transactionList.add(tr1);
                }
            }
        }

    }
    //display Transfer List
    public void showTransacton() throws BankException
    {
        System.out.println("Enter the account no. whose transaction history you want to see");
        String accountNumber=sc.next();
        if(accountNumber.length()<10 || accountNumber.length()>10) //checking for account validity
        {
            throw new BankException.InvalidAccountException();
        }
        BankAccount accounttoHistory=null;
        for(BankAccount bankAccount: bankAccountList) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                accounttoHistory = bankAccount;
                break;
            }
        }
            if(accounttoHistory==null)
            {
                throw new BankException.NonExistenceAccountException();
            }
            else
            {
                for(Transaction transaction: accounttoHistory.transactionList)
                {
                    System.out.println(transaction);
                }
            }
    }
}

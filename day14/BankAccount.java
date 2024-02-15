package day14;

import java.util.ArrayList;
import java.util.List;

public class BankAccount
{
    private String accountNumber;
    private double balance;
    List<Transaction> transactionList; //List of Transaction History for each user
// Constructor
    BankAccount(String accountNumber,double balance)
    {
        this.accountNumber=accountNumber;
        this.balance=balance;
        transactionList=new ArrayList<>();
    }
    //set amount

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
}


package day14;
//A class For Transactions
public class Transaction
{
    private int transactionId;
    private String transactionType;
    double amount;

    Transaction(int transactionId,String transactionType,double amount)
    {

        this.amount=amount;
        this.transactionId=transactionId;
        this.transactionType=transactionType;
    }
    public String toString()
    {
        return "TransactionId: "+ transactionId+"\nTransaction Type: "+transactionType+"\n Amount Transfer: "+amount;
    }
}

package day14;

public class BankException extends Exception
{
    // InvalidAccountException nested class
    public static class InvalidAccountException extends BankException {
        public InvalidAccountException() {
            System.out.println("Account Number in not Valid.Its size must be of 10 digits");
        }
    }

    // NegativeAmountException nested class
    public static class NegativeAmountException extends BankException {
        public NegativeAmountException() {
            System.out.println("Amount cannot be negative");
        }
    }
    //InsufficientFundsException
    public static class InsufficientFundsException extends BankException
    {
        public InsufficientFundsException()
        {
            System.out.println("Insufficient Balance. Please enter Valid Amount");
        }
    }
    //NonExistenceAccountException
    public static class NonExistenceAccountException extends BankException
    {
        public NonExistenceAccountException()
        {
            System.out.println("The Account does not exists");
        }
    }
//public String toString()
//{
//    return "Amount cannot be negative";
//}
//
//    @Override
//    public String getMessage() {
//        return "Amount cannot be negative";
//    }
}

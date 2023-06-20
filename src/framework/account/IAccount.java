package framework.account;
import framework.transaction.ITransaction;

public interface IAccount {
    public Double getBalance();
    public void addTransaction(ITransaction transaction)  throws Exception;
    public void addInterest();
}

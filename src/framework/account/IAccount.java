package framework.account;

import framework.transaction.ITransaction;

public interface IAccount {
    Double getBalance();
    void addTransaction(ITransaction transaction)  throws Exception;
    void addInterest();
}

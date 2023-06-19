package framework.account;

import framework.transaction.ITransaction;

import java.util.List;

public abstract class Account implements IAccount {

    private String accountNum;
    private List<ITransaction> transactions;

    public String getAccountNum() {
        return accountNum;
    }

    @Override
    public Double getBalance() {
        return null;
    }

    @Override
    public void addTransaction() {
//        transactions.add()
    }

    @Override
    public abstract void addInterest();
}

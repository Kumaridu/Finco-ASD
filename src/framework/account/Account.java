package framework.account;

import framework.owner.Owner;
import framework.transaction.ITransaction;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements IAccount {
    private Double balance = 0.0;
    private String accountNum;
    private List<ITransaction> transactions = new ArrayList<>();

    public Account(Double balance){
        this.balance = balance;
        this.accountNum = Owner.getNextAccountNumber();
    }

    public String getAccountNum() {
        return accountNum;
    }

    @Override
    public Double getBalance() {
        return balance;
    }

    @Override
    public void addTransaction(ITransaction transaction) throws Exception{
        if (transaction.getAmount() + this.balance < 0){
            throw new Exception("Transaction amount more exceeds account balance.");
        }

        this.balance += transaction.getAmount();

        this.transactions.add(transaction);
    }

    @Override
    public abstract void addInterest();

    @Override
    public String toString() {
        return "Account number: " + this.accountNum + "\n" + "Balance: " + this.balance + " \n" +
                transactions.toString();
    }
}

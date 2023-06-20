package framework.account;

import framework.owner.Owner;
import framework.party.IParty;
import framework.transaction.ITransaction;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements IAccount {
    private Double balance = 0.0;
    private final IParty accountOwner;
    private final String accountNum;
    private final List<ITransaction> transactions = new ArrayList<>();

    public Account(Double balance, IParty accountOwner){
        this.balance = balance;
        this.accountNum = Owner.getNextAccountNumber();
        this.accountOwner = accountOwner;
        this.accountOwner.addAccount(this);
        Owner.addAccount(this);
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
            throw new Exception("Debit Transaction amount exceeds account balance.");
        }

        this.balance += transaction.getAmount();

        this.transactions.add(transaction);
        this.accountOwner.sendEmail(transaction);
    }

    @Override
    public abstract void addInterest();

    @Override
    public String toString() {
        return "Account number: " + this.accountNum + "\n" + "Balance: " + this.balance + " \n" +
                transactions.toString();
    }
}

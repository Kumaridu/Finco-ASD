package framework.account;

import framework.owner.Owner;
import framework.party.IParty;
import framework.transaction.ITransaction;
import framework.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class Account implements IAccount {
    private Double balance = 0.0;
    private final IParty accountOwner;
    private final String accountNum;
    private final List<ITransaction> transactions = new ArrayList<>();

    public Account(Double balance, IParty accountOwner) {
        try {
            this.accountNum = Owner.getNextAccountNumber();
            this.accountOwner = accountOwner;
            this.accountOwner.addAccount(this);
            Owner.addAccount(this);
            this.addTransaction("New Account Deposit", balance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getAccountNum() {
        return accountNum;
    }

    @Override
    public Double getBalance() {
        return balance;
    }

    @Override
    public void addTransaction(String name, Double amount) throws Exception{
        ITransaction transaction = new Transaction(name, amount, this);

        if (transaction.getAmount() + this.balance < 0){
            throw new Exception("Debit Transaction amount exceeds account balance.");
        }

        this.balance += transaction.getAmount();

        this.transactions.add(transaction);
        this.accountOwner.sendEmail(transaction);
    }

    @Override
    public abstract void addInterest();

    public IParty getAccountOwner() {
        return accountOwner;
    }

    @Override
    public List<ITransaction> credits() {
        return getTransactions((tran) -> tran.getAmount() > 0.0);
    }

    @Override
    public List<ITransaction> debits() {
        return getTransactions((tran) -> tran.getAmount() < 0.0);
    }

    public List<ITransaction> transactions() {
        return transactions;
    }

    private List<ITransaction> getTransactions(Predicate<ITransaction> predicate){
        List<ITransaction> trans = new ArrayList<>();
        for (ITransaction tran : transactions){
            if (predicate.test(tran)){
                trans.add(tran);
            }
        }

        return trans;
    }

    @Override
    public String toString() {
        return "Account number: " + this.accountNum + "\n" + "Balance: " + this.balance + " \n" +
                transactions.toString();
    }
}

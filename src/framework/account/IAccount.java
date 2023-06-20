package framework.account;
import framework.party.IParty;
import framework.transaction.ITransaction;

import java.util.List;

public interface IAccount {
    public Double getBalance();
    public void addTransaction(String name, Double amount)  throws Exception;
    public void addInterest();
    public IParty getAccountOwner();
    public List<ITransaction> accountTransaction();
    public List<ITransaction> accountCredits();
    public List<ITransaction> accountDebits();
}

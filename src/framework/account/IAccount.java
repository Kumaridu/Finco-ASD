package framework.account;
import framework.party.IParty;

public interface IAccount {
    public Double getBalance();
    public void addTransaction(String name, Double amount)  throws Exception;
    public void addInterest();
    public IParty getAccountOwner();
}

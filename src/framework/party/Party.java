package framework.party;

import framework.account.IAccount;
import framework.transaction.ITransaction;

import java.util.ArrayList;
import java.util.List;

public abstract class Party implements IParty{
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private List<IAccount> accounts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public void addAccount(IAccount account) {
        this.accounts.add(account);
    }

    @Override
    public void removeAccount(IAccount account) {
       this.accounts.remove(account);
    }
    @Override
    public abstract void sendEmail(ITransaction transaction);
}

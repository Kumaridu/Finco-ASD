package framework.party;

import framework.account.IAccount;
import framework.transaction.ITransaction;

public interface IParty {
    void addAccount(IAccount account);
    void removeAccount(IAccount account);
    void sendEmail(ITransaction transaction);
}

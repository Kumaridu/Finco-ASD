package framework;
import framework.account.Account;
import framework.party.IParty;

public class ConcAccount extends Account {
    ConcAccount(Double balance, IParty party) {
        super(balance, party);
    }

    @Override
    public void addInterest() {
        //
    }
}

package framework;
import framework.account.Account;
import framework.party.IParty;

public class ConcAccount extends Account {
    public ConcAccount(Double balance, IParty party) {
        super(balance, party);
    }

    @Override
    public void addInterest() {
        Double balance = getBalance();
        double interest = 0.5 * balance;
        balance += interest;
        setBalance(balance);
    }
}

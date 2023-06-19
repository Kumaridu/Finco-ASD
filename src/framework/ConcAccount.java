package framework;
import framework.account.Account;

public class ConcAccount extends Account {
    ConcAccount(Double balance) {
        super(balance);
    }

    @Override
    public void addInterest() {
        //
    }
}

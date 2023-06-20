package banking.account;

import framework.account.Account;
import framework.party.IParty;

public class Checking extends Account {

    private Double interestRate;

    public Checking(Double balance, IParty accountOwner) {
        super(balance, accountOwner);
    }

    @Override
    public void addInterest() {
        Double balance = getBalance();
        double interest = interestRate * balance;
        balance += interest;
        setBalance(balance);
    }
}

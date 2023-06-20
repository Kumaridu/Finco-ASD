package banking.account;

import framework.account.Account;
import framework.party.IParty;

public class Saving extends Account {

    private Double interestRate;

    public Saving(Double balance, IParty accountOwner) {
        super(balance, accountOwner);
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void addInterest() {
        Double balance = getBalance();
        double interest = interestRate * balance;
        balance += interest;
        setBalance(balance);
    }
}

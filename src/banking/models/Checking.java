package banking.models;

import framework.party.IParty;

public class Checking extends BankAccount {

    public Checking(Double balance, IParty accountOwner) {
        super(balance, accountOwner);
    }

    @Override
    public Double getInterestRate() {
        return BankAccount.CHECKING_INTEREST_RATE;
    }

}

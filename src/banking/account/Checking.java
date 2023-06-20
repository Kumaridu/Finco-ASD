package banking.account;

import framework.party.IParty;

public class Checking extends BankAccount {

    public Checking(Double balance, IParty accountOwner) {
        super(balance, accountOwner);
    }

}

package banking.account;

import framework.party.IParty;

public class Saving extends BankAccount {

    public Saving(Double balance, IParty accountOwner) {
        super(balance, accountOwner);
    }
}

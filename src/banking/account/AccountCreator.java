package banking.account;

import framework.party.IParty;

public class AccountCreator {

    public static Saving createSaving(Double balance, IParty accountOwner) {
        return new Saving(balance, accountOwner);
    }

    public static Checking createChecking(Double balance, IParty accountOwner) {
        return new Checking(balance, accountOwner);
    }
}

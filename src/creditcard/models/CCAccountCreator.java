package creditcard.models;

import framework.party.IParty;

public class CCAccountCreator {

    public static CCAccount createAccount(IParty accountOwner, String accountType) {
        if(accountType.equals("Gold")) {
            return new Gold(accountOwner);
        }

        if (accountType.equals("Silver")) {
            return new Silver(accountOwner);
        }

        if (accountType.equals("Copper")) {
            return new Copper(accountOwner);
        }

        return null;
    }
}

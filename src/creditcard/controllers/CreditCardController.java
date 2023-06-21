package creditcard.controllers;

import creditcard.CCAccount;
import creditcard.CCAccountCreator;
import framework.account.Account;
import framework.owner.Owner;
import framework.party.IParty;
import framework.party.Organization;
import framework.party.PartyCreator;



public class CreditCardController {

    public static void createAccount(String name, String street, String city, String zip,
                                        String email, String accountType) {


        System.out.println("Creating a new credit account type: " + accountType);
        IParty person = PartyCreator.createParty(name, street, city, zip, email);
        CCAccountCreator.createAccount(person, accountType);
        System.out.println("After adding new account, owner account size: " + Owner.getAccounts().size());
    }
}

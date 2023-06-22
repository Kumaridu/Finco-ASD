package framework.controllers;

import banking.models.AccountCreator;
import framework.ConcAccount;
import framework.account.IAccount;
import framework.owner.Owner;
import framework.party.IParty;
import framework.party.PartyCreator;
import framework.utilities.Response;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BaseController {
    public static Response debit(String accountNumber, Double amount) {
        return Owner.updateAccountBalance(accountNumber, -amount);
    }

    public static Response credit(String accountNumber, Double amount) {
        return Owner.updateAccountBalance(accountNumber, amount);
    }

    public static void applyInterest(){
        Owner.notifyApplyInterest();
    }
    public static List<IAccount> allAccounts(){
        return Owner.getAccounts();
    }
    public static void createAccount(String clientName, String street, String city, String zip,
                                     String email, String dateOfBirthSt, String accountType) {

        System.out.println("Creating new Account");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthSt, formatter);
        IParty person = PartyCreator.createParty(clientName, street, city, zip, email, dateOfBirth);

        ConcAccount acc = new ConcAccount(0.0, person);

        System.out.println("After adding a new account, owner account size: " + Owner.getAccounts().size());
    }
}

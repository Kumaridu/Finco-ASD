package banking.controllers;

import banking.AccountCreator;
import framework.owner.Owner;
import framework.party.IParty;
import framework.party.PartyCreator;
import framework.utilities.Response;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankController {

    public static void createPersonalAccount(String clientName, String street, String city, String zip,
                                 String email, String dateOfBirthSt, String accountType) {

        System.out.println("Adding new Personal Account");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthSt, formatter);
        IParty person = PartyCreator.createPerson(clientName, street, city, zip, email, dateOfBirth);

        if(accountType.equals("S")) {
            AccountCreator.createSaving(0.0, person);
        } else {
            AccountCreator.createChecking(0.0, person);
        }
        System.out.println("After adding new personal account, owner account size: " + Owner.getAccounts().size());
    }

    public static void createCompanyAccount(String clientName, String street, String city, String zip,
                           String email, int noOfEmp , String accountType) {

        System.out.println("Adding new company account");

        IParty organization = PartyCreator.createOrganization(clientName, street, city, zip, email, noOfEmp);

        if(accountType.equals("S")) {
            AccountCreator.createSaving(0.0, organization);
        } else {
            AccountCreator.createChecking(0.0, organization);
        }

        System.out.println("After adding new company account ,owner account size: " + Owner.getAccounts().size());
    }

    public static void depositMoney(String accountNumber, Double amount) {

    }

    public static Response withdrawalMoney(String accountNumber, Double amount) {
        return new Response(false, "Error");
    }
}

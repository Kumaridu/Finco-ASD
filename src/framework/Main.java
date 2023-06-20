package framework;

import framework.account.Account;
import framework.owner.Owner;
import framework.party.IOrganization;
import framework.party.PartyCreator;


public class Main {
    public static void main(String[] args) {
        IOrganization org = PartyCreator.createOrganization(
                "Sindhu",
                "1000 Nth Strt",
                "Fairfield",
                "52278",
                "sindhu@email.com",
                123
        );

        Account acc = new ConcAccount(100.0, org);

        try {
            acc.addTransaction("Walmat expense", -20.0);
            acc.addTransaction("Walmat expense-xxx", -40.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        Account acc2 = new ConcAccount(10.0, org);

        try {
            acc2.addTransaction("Walmat expense", -20.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        Owner.notifyApplyInterest();


        System.out.println(Owner.getAccounts().toString());
    }
}
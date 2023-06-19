package framework;

import framework.account.Account;
import framework.owner.Owner;
import framework.party.IPerson;
import framework.party.PartyCreator;
import framework.transaction.Transaction;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        IPerson person = PartyCreator.createPerson(
                "Sindhu",
                "1000 Nth Strt",
                "Fairfield",
                "52278",
                LocalDate.of(1990, 6, 19)
        );

        Account acc = new ConcAccount(100.0);

        try {
            acc.addTransaction(new Transaction("Walmat expense", -20.0));
            acc.addTransaction(new Transaction("Walmat expense-xxx", -40.0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        Account acc2 = new ConcAccount(10.0);

        try {
            acc2.addTransaction(new Transaction("Walmat expense", -20.0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        person.addAccount(acc);
        person.addAccount(acc2);
        Owner.addAccount(acc);
        Owner.addAccount(acc2);

        Owner.notifyApplyInterest();


        System.out.println(Owner.getAccounts().toString());
    }
}
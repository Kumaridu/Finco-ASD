package framework.party;

import framework.transaction.ITransaction;

import java.time.LocalDate;

public class Person extends Party implements IPerson {

    private LocalDate birthDate;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public void sendEmail(ITransaction transaction) {

    }
}

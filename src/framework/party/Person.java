package framework.party;
import framework.owner.Owner;
import framework.transaction.ITransaction;
import framework.utilities.Email;

import java.time.LocalDate;

public class Person extends Party implements IPerson {
    private LocalDate birthDate;

    /**
     * Create a new Person object
     * @param name
     * @param street
     * @param city
     * @param zip
     * @param birthDate
     */
    public Person(String name, String street, String city, String zip, String email, LocalDate birthDate){
        super(name, street, city, zip, email);
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public void sendEmail(ITransaction transaction) {
       if (Math.abs(transaction.getAmount()) > 400){
           new Email("New Transaction", Owner.getEmail(), transaction.getAccount().getAccountOwner().getEmail(), transaction.toString());
       }
    }
}

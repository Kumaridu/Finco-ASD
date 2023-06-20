package framework.party;
import java.time.LocalDate;

public class PartyCreator {

    /**
     * Creates a new IPerson object
     * @param name
     * @param street
     * @param city
     * @param zip
     * @param dateOfBirth
     * @param email
     * @return
     */
    public static IPerson createPerson(String name, String street, String city, String zip, String email, LocalDate dateOfBirth){
        return new Person(name, street, city, zip, email, dateOfBirth);
    }

    /**
     * Creates and returns an organization object
     * @param name
     * @param street
     * @param city
     * @param zip
     * @param numOfEmployees
     * @param email
     * @return
     */
    public static IOrganization  createOrganization(String name, String street, String city, String zip, String email, int numOfEmployees) {
        return new Organization(name, street, city, zip, email, numOfEmployees);
    }
}

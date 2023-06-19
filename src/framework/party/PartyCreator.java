package framework.party;
import java.time.LocalDate;

public abstract class PartyCreator {

    /**
     * Creates a new IPerson object
     * @param name
     * @param street
     * @param city
     * @param zip
     * @param dateOfBirth
     * @return
     */
    public static IPerson createPerson(String name, String street, String city, String zip, LocalDate dateOfBirth){
        return new Person(name, street, city, zip, dateOfBirth);
    }

    /**
     * Creates and returns an organization object
     * @param name
     * @param street
     * @param city
     * @param zip
     * @param numOfEmployees
     * @return
     */
    public static IOrganization  createOrganization(String name, String street, String city, String zip, int numOfEmployees) {
        return new Organization(name, street, city, zip, numOfEmployees);
    }
}

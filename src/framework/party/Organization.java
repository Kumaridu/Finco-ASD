package framework.party;
import framework.transaction.ITransaction;

public class Organization extends Party implements IOrganization {
    private int numOfEmployees;

    /**
     *
     * @param name
     * @param street
     * @param city
     * @param zip
     * @param numOfEmployees
     */
    public Organization(String name, String street, String city, String zip, int numOfEmployees) {
        super(name, street, city, zip);
        this.numOfEmployees = numOfEmployees;
    }

    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    @Override
    public void sendEmail(ITransaction transaction) {

    }
}

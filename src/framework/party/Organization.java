package framework.party;
import framework.owner.Owner;
import framework.services.Email;
import framework.services.EmailService;
import framework.transaction.ITransaction;

public class Organization extends Party implements IOrganization {
    private int numOfEmployees;

    /**
     * Create a new Organization object
     * @param name
     * @param street
     * @param city
     * @param zip
     * @param email
     * @param numOfEmployees
     */
    public Organization(String name, String street, String city, String zip, String email, int numOfEmployees) {
        super(name, street, city, zip, email);
        this.numOfEmployees = numOfEmployees;
    }

    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    @Override
    public void sendEmail(ITransaction transaction) {
        EmailService.sendEmail(
                new Email("New Transaction", Owner.getEmail(), transaction.getAccount().getAccountOwner().getEmail(), transaction.toString())
        );
    }
}

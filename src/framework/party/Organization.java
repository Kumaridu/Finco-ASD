package framework.party;
import framework.transaction.ITransaction;

public class Organization extends Party {

    private int noOfEmployees;

    public int getNoOfEmployees() {
        return noOfEmployees;
    }

    @Override
    public void sendEmail(ITransaction transaction) {

    }
}

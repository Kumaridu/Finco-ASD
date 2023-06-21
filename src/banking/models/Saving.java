package banking.models;
import framework.party.IParty;

public class Saving extends BankAccount {
    public Saving(Double balance, IParty accountOwner) {
        super(balance, accountOwner);
    }
    @Override
    public Double getInterestRate() {
        return BankAccount.SAVING_INTEREST_RATE;
    }
}

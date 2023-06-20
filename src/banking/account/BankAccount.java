package banking.account;

import framework.account.Account;
import framework.party.IParty;

public abstract class BankAccount extends Account {

    public static Double SAVING_INTEREST_RATE = 0.34;
    public static Double CHECKING_INTEREST_RATE = 0.3232;

    public BankAccount(Double balance, IParty accountOwner) {
        super(balance, accountOwner);
    }

    public abstract Double getInterestRate();

    @Override
    public void addInterest() {
        Double balance = getBalance();
        double interest = getInterestRate() * balance;
        balance += interest;
        setBalance(balance);
    }
}

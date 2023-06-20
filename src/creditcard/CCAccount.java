package creditcard;

import framework.account.Account;
import framework.party.IParty;

import java.time.LocalDate;

public abstract class CCAccount extends Account {
    private LocalDate expDate;
    private Double lastMonthBalance;

    public CCAccount(IParty accountOwner) {
        super(0.0, accountOwner);
        this.expDate = LocalDate.now().plusYears(4);
        this.lastMonthBalance = 0.0;
    }
    public Double getLastMonthBalance(){
        return lastMonthBalance;
    }
    public Double totalMonthlyCredits(){
        return 0.0;
    }
    public Double totalMonthlyCharges(){
        return 0.0;
    }

    public abstract Double getNewMonthlybalance();
    public abstract Double getMonthlyAmountDue();
    public abstract void addInterest();


}

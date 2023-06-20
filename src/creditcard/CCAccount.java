package creditcard;

import framework.account.Account;

public abstract class CCAccount extends Account {
    private String expDate;
    private Double lastMonthBalance = 0.0;
    public CCAccount(Double balance, IParty accountOwner,String expDate, Double lastMonthBalance) {
        super(balance, accountOwner);
        this.expDate=expDate;
        this.lastMonthBalance=lastMonthBalance;
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

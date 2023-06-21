package creditcard;

import framework.account.Account;
import framework.party.IParty;
import framework.transaction.ITransaction;

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
        for(ITransaction accountTransaction:this.transactions()){

            if (accountTransaction.getDate().isBefore(expDate.withDayOfMonth(1))) {
                lastMonthBalance += accountTransaction.getAmount();
            }
        }
        return lastMonthBalance;

    }
    public Double totalMonthlyCredits(){
        Double monthlyCredits=0.0;
        for(ITransaction accountTransaction:this.debits()){
            if (accountTransaction.getDate().isBefore(expDate.withDayOfMonth(1))) {
                monthlyCredits += accountTransaction.getAmount();
            }
        }
        return monthlyCredits;
    }
    public Double totalMonthlyCharges(){
        Double monthlyCharges=0.0;
        for(ITransaction accountTransaction:this.credits()){
            if (accountTransaction.getDate().isBefore(expDate.withDayOfMonth(1))) {
                monthlyCharges += accountTransaction.getAmount();
            }
        }
        return monthlyCharges;
    }

    public abstract Double getNewMonthlybalance();
    public abstract Double getMonthlyAmountDue();
    public abstract void addInterest();


}

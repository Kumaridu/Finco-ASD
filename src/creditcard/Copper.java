package creditcard;

import framework.party.IParty;

public class Copper extends CCAccount{
    Double mi=0.20;
    Double mp=0.24;
    public Copper(IParty accountOwner) {
        super(accountOwner);
    }

    @Override
    public Double getNewMonthlybalance() {
        Double newBalance;
        newBalance=this.getLastMonthBalance()-totalMonthlyCredits()+this.totalMonthlyCharges()+mi*(this.getLastMonthBalance()-this.totalMonthlyCredits());
        return newBalance;
    }

    @Override
    public Double getMonthlyAmountDue() {
        Double amountDue;
        amountDue=mp*this.getNewMonthlybalance();
        return amountDue;
    }

    @Override
    public void addInterest() {

    }
}

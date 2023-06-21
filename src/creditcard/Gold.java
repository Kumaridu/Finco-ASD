package creditcard;

import framework.party.IParty;

public class Gold extends CCAccount{
    private Double mi=0.25;
    private Double mp=0.25;

    public Gold(IParty accountOwner) {
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

package creditcard;

import framework.party.IParty;

public class Silver extends CCAccount{
    private Double mi=0.16;
    private Double mp=0.18;
    public Silver(IParty accountOwner) {
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

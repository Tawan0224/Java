/*
Name - Soe Min Min Latt
ID - 6611938
Sec - 541
 */
package u6611938;

public class BlackCardHolder extends LoyaltyCardHolder{
    public BlackCardHolder(int customerNumber, String firstName, String lastName) {
        super(customerNumber, firstName, lastName);
    }

    public BlackCardHolder(int customerNumber, String firstName, String lastName, int year) {
        super(customerNumber, firstName, lastName, year);
    }

    @Override
    String getType() {
        return "Black";
    }

    @Override
    void accumulateBonusPoints(int spending, boolean isOnline) {
        int point = 0;
        if (isOnline){
            while(spending >= 20) {
                point += 2;
                spending = spending - 20;
            }
        }else{
            while(spending >= 20) {
                point += 1;
                spending = spending - 20;
            }
        }
        setBonusPoint(point);
    }

    @Override
    boolean redeemPoints(int requiredPoints) {
        if (requiredPoints < getBonusPoint()) {
            setBonusPoint((int) (getBonusPoint() - (requiredPoints * 0.98)));
            return true;
        } else {
            return false;
        }
    }
}

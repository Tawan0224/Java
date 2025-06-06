/*
Name - Soe Min Min Latt
ID - 6611938
Sec - 541
 */
package u6611938;

public class RedCardHolder extends LoyaltyCardHolder {
    public RedCardHolder(int customerNumber, String firstName, String lastName) {
        super(customerNumber, firstName, lastName);
    }

    public RedCardHolder(int customerNumber, String firstName, String lastName, int year) {
        super(customerNumber, firstName, lastName, year);
    }

    @Override
    String getType() {
        return "Red";
    }

    @Override
    void accumulateBonusPoints(int spending, boolean isOnline) {
        int point = 0;
        while (spending >= 25) {
            point += 1;
            spending = spending - 25;
        }
        setBonusPoint(point);
    }

    @Override
    boolean redeemPoints(int requiredPoints) {
        if (requiredPoints < getBonusPoint() && getJoinedYear() <= 2014) {
            setBonusPoint((int) (getBonusPoint() - (requiredPoints * 0.99)));
            return true;
        } else {
            return false;
        }
    }
}

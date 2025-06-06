/*
Name - Soe Min Min Latt
ID - 6611938
Sec - 541
 */
package u6611938;

abstract public class LoyaltyCardHolder {
    private int customerNumber;
    private String firstName;
    private  String lastName;
    private int bonusPoint;
    private int joinedYear;

    public LoyaltyCardHolder(int customerNumber, String firstName, String lastName) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bonusPoint = 0;
        this.joinedYear = 2024;
    }

    public LoyaltyCardHolder(int customerNumber, String firstName, String lastName, int year) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bonusPoint = 0;
        this.joinedYear = year;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(int bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public int getJoinedYear() {
        return joinedYear;
    }

    public void setJoinedYear(int joinedYear) {
        this.joinedYear = joinedYear;
    }

    abstract String getType();
    abstract void accumulateBonusPoints(int spending, boolean isOnline);
    abstract boolean redeemPoints(int requiredPoints);

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d member since %d", customerNumber, firstName, lastName, getType(), bonusPoint, joinedYear);
    }
}

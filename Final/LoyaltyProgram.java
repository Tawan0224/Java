/*
Name - Soe Min Min Latt
ID - 6611938
Sec - 541
 */
package u6611938;

import java.util.ArrayList;

public class LoyaltyProgram {
    public static void main(String[] args) {
        ArrayList<LoyaltyCardHolder> customers = new ArrayList<>();
        BlackCardHolder customer1 = new BlackCardHolder(1001, "James", "Bond");
        RedCardHolder customer2 = new RedCardHolder(1002, "Jane", "Parker", 2012);
        BlackCardHolder customer3 = new BlackCardHolder(1003, "Mariam", "Baldwin", 2020);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        customer1.accumulateBonusPoints(10000, true);
        customer2.accumulateBonusPoints(1500,true);
        customer3.accumulateBonusPoints(5600, false);

        customer1.redeemPoints(300);
        customer2.redeemPoints(10);
        customer3.redeemPoints(150);
        for (LoyaltyCardHolder customer: customers){
            System.out.println(customer.toString());
        }
    }
}

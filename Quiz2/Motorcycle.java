/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package quiz2_6611938;

public class Motorcycle extends Vehicle implements Ridable{
    @Override
    public void ride() {
        System.out.println("Motorcycle is ridden by a biker");
    }
    @Override
    public void move() {
        System.out.println("Motorcycle is running");
    }
}

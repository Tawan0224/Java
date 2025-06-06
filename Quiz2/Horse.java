/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package quiz2_6611938;

public class Horse extends Animal implements Ridable{
    @Override
    public void move() {
        System.out.println("Horse is jogging");
    }

    @Override
    public void ride() {
        System.out.println("Horse is ridden by a jockey");
    }
}

/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week07;
import java.util.Random;

public class Dice {
    private int faceValue;
    public Dice() {
        roll();
    }

    public int getFaceValue() {
        return this.faceValue;
    }

    public int roll() {
        Random randomizer = new Random();
        this.faceValue = randomizer.nextInt(6) + 1;

        return this.faceValue;
    }
}

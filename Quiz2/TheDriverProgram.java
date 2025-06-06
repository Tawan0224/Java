/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package quiz2_6611938;

public class TheDriverProgram {
    public static void main(String[] args) {
        Movable[] testMove = {new Bird(), new Horse(), new Motorcycle(), new Car()};
        for ( Movable each: testMove){
            each.move();
            if(each instanceof Ridable)
                ((Ridable)each).ride();
        }
    }
}

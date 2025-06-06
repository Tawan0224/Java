/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week08.Animal;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new AmericanRobin();
        animals[1] = new AmericanRobin();
        animals[2] = new DomesticCanary();

        for (Animal animal : animals) {
            System.out.println(animal);
            animal.eat();
            animal.move();
            System.out.println();
        }
    }
}

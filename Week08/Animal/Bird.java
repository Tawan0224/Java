/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week08.Animal;

abstract public class  Bird extends Animal {
    public Bird(String kind, String appearance){
        super(kind,appearance);
    }

    @Override
    public void move() {
        System.out.println("flies through the air");
    }

    @Override
    public void eat() {
        System.out.println("eats seeds and insects");
    }

    @Override
    public String toString() {
        return String.format("%s, %s", getKind(), getAppearance());
    }
}

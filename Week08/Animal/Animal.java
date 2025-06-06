/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week08.Animal;

abstract public class Animal {
    private String kind;
    private String appearance;
    public Animal (String kind, String appearance){
        this.kind = kind;
        this.appearance = appearance;
    }
    abstract public void eat();
    abstract public void move();

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }
    @Override
    public String toString() {
        return String.format("%s, %s", kind, appearance);
    }
}

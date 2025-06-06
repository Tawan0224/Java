/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week08.Animal;

public class DomesticCanary extends Bird {
    public DomesticCanary(){
        super("domesticcanary", "yellow, orange, black, brown, white, red");
    }
    @Override
    public String toString() {
        return String.format("%s, %s", getKind(), getAppearance());
    }
}

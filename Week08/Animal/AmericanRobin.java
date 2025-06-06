/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week08.Animal;

public class AmericanRobin extends Bird {
    public AmericanRobin(){
        super("americanrobin", "red breast");
    }

    @Override
    public String toString() {
        return String.format("%s, %s", getKind(), getAppearance());
    }
}

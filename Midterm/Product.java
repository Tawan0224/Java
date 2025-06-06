/*
Name - Soe Min Min Latt
ID - 6611938
Sec - 541
 */

package u6611938mid;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private String unit;

    public Product(){
        this.id = 9999;
        this.name = "Dummy";
        this.quantity = 0;
        this.unit = "item";
    }

    public Product(int id, String name,  String unit){
        this.id = id;
        this.name = name;
        this.quantity = 0;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean restock(int numItems){
        if (numItems >0){
            quantity += numItems;
            return true;
        }else {
            return false;
        }
    }

    public boolean sell(int numItems){
        if(quantity > numItems){
            quantity -= numItems;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        if(quantity > 1){
            return id + " " + name+ ":" + quantity + " " + unit + "s";
        } else {
            return id + " " + name+ ":" + quantity + " " + unit;
        }
    }
}

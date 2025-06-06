/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week15;

public class Seat {
    private int price;
    private boolean isAvailable;

    public Seat(){
        this.price = 200;
        this.isAvailable = true;
    }
    public Seat(int price){
        this.price = price;
        this.isAvailable = true;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean setPrice(int price) {
        if(price > 0){
            this.price = price;
            return true;
        }else{
            return false;
        }
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public boolean book(){
        if (this.isAvailable){
            this.isAvailable = false;
            return true;
        }else{
            return false;
        }
    }
}

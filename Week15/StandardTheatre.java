/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week15;

public class StandardTheatre extends Theatre {
    public StandardTheatre(String title) {
        super(title, 10, 20);

        //create seats for the front section
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = new Seat(200);
            }
        }

        //create seats for the back Section
        for (int i = 5; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = new Seat(300);
            }
        }
    }

}

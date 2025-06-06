/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week15;

public class PremiumTheatre extends Theatre {
    public PremiumTheatre(String title) {
        super(title, 5, 20);

        //create seats for the first 4 rows
        for (int i = 0; i < rows-1; ++i) {
            for (int j = 0; j < columns; ++j) {
                seats[i][j] = new Seat(500);
            }
        }

        //create seats for last row
        for (int i = 0; i < columns; ++i) {
            seats[rows-1][i] = new Seat(700);
        }
    }
}

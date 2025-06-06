/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week15;

abstract public class Theatre {
    private String movieTitle;
    protected int rows;
    protected int columns;
    protected Seat[][] seats;

    private Theatre(){
        this.movieTitle = "The Num";
        this.rows = 1;
        this.columns = 1;
        this.seats = new Seat[rows][columns];
    }
    public Theatre(String title, int rows, int columns){
        this.movieTitle = title;
        this.rows = rows;
        this.columns = columns;
        this.seats = new Seat[rows][columns];
    }

    public void setMovieTitle(String title) {
        this.movieTitle = title;
    }
    public boolean book(int row, int column) {
        return seats[row][column].book();
    }
    //return the sales amount inTHB
    public int getRevenue(){
        int totalRevenue = 0;
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (!seat.isAvailable()) {
                    totalRevenue += seat.getPrice();
                }
            }
        }
        return totalRevenue;
    }
    //return the number of tickets sold in this theatre
    public int getNumberOfTicketSold() {
        int ticketsSold = 0;
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (!seat.isAvailable()) {
                    ticketsSold++;
                }
            }
        }
        return ticketsSold;
    }
}

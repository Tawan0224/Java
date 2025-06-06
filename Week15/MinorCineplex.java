/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week15;

import java.util.ArrayList;
import java.util.Scanner;

public class MinorCineplex {
    static ArrayList<Theatre> theatres = new ArrayList<>();
    static String currentMovieTitle = "The Num";

    public static void main(String[] args) {
        theatres.add(new StandardTheatre(currentMovieTitle));
        theatres.add(new StandardTheatre(currentMovieTitle));
        theatres.add(new StandardTheatre(currentMovieTitle));
        theatres.add(new PremiumTheatre(currentMovieTitle));

        Scanner reader = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("1. Book a seat");
            System.out.println("2. Edit movie title");
            System.out.println("3. View sales report");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            choice = reader.nextInt();
            reader.nextLine();

            if (choice == 1) {
                bookSeat(reader);
            } else if (choice == 2) {
                editMovieTitle(reader);
            } else if (choice == 3) {
                viewSalesReport();
            } else if (choice == 4) {
                System.out.println("Exiting the program...");
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
        reader.close();
    }

    public static void bookSeat(Scanner reader) {
        System.out.print("Enter Theatre Number (1-4): ");
        int theatreNumber = reader.nextInt();
        reader.nextLine();
        if (theatreNumber < 1 || theatreNumber > theatres.size()) {
            System.out.println("Invalid theatre number.");
            return;
        }

        System.out.print("Enter Row: ");
        int row = reader.nextInt();
        System.out.print("Enter Column: ");
        int column = reader.nextInt();

        boolean bookingSuccess = theatres.get(theatreNumber - 1).book(row, column);
        if (bookingSuccess) {
            System.out.println("Seat booked successfully.");
        } else {
            System.out.println("Seat is already taken.");
        }
    }

    public static void editMovieTitle(Scanner reader) {
        System.out.print("Enter new movie title: ");
        String newTitle = reader.nextLine();
        currentMovieTitle = newTitle;

        for (Theatre theatre : theatres) {
            theatre.setMovieTitle(newTitle);
        }
        System.out.println("Movie title updated to: " + newTitle);
    }

    public static void viewSalesReport() {
        System.out.println("Sales Report for " + currentMovieTitle);

        for (int i = 0; i < theatres.size(); i++) {
            int ticketsSold = getTotalTicketSold(i + 1);
            int revenue = getTotalRevenue(i + 1);
            System.out.println("Theatre " + (i + 1) + ": Tickets Sold = " + ticketsSold + ", Revenue = " + revenue + " THB");
        }

        System.out.println("Total Tickets Sold: " + getTotalTicketSold());
        System.out.println("Total Revenue: " + getTotalRevenue() + " THB");
    }

    public static int getTotalRevenue(int theatreNumber) {
        return theatres.get(theatreNumber - 1).getRevenue();
    }

    public static int getTotalRevenue() {
        int totalRevenue = 0;
        for (Theatre theatre : theatres) {
            totalRevenue += theatre.getRevenue();
        }
        return totalRevenue;
    }

    public static int getTotalTicketSold(int theatreNumber) {
        return theatres.get(theatreNumber - 1).getNumberOfTicketSold();
    }

    public static int getTotalTicketSold() {
        int totalTicketsSold = 0;
        for (Theatre theatre : theatres) {
            totalTicketsSold += theatre.getNumberOfTicketSold();
        }
        return totalTicketsSold;
    }
}




/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week08.Golf;

import java.io.*;
import java.util.*;

public class GolfTournament {
    private List<Golfer> golfers;
    private static final String FILE_NAME = "golfers.csv";

    public GolfTournament() {
        golfers = new ArrayList<>();
        loadGolfers();
    }

    public void addGolfer(Golfer golfer) {
        for (Golfer g : golfers) {
            if (g.getId().equals(golfer.getId())) {
                System.out.println("Golfer ID already exists.");
                return;
            }
        }
        golfers.add(golfer);
    }

    public void updateScore(String id, int round, int score) {
        for (Golfer golfer : golfers) {
            if (golfer.getId().equals(id)) {
                golfer.setScore(round, score);
                return;
            }
        }
        System.out.println("Golfer ID not found.");
    }

    public void displayGolfers() {
        golfers.sort(Comparator.comparing(Golfer::getLastName));
        for (Golfer golfer : golfers) {
            System.out.println(golfer.getLastName() + ", " + golfer.getFirstName() + " " + golfer.getFormattedTotalScore());
        }
        System.out.println();
    }

    public void showLeaderboard() {
        golfers.sort(Comparator.comparingInt(Golfer::getTotalScore));
        for (int i = 0; i < Math.min(10, golfers.size()); i++) {
            Golfer golfer = golfers.get(i);
            System.out.println(golfer.getLastName() + ", " + golfer.getFirstName() + " " + golfer.getFormattedTotalScore());
        }
        System.out.println();
    }

    private void loadGolfers() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Golfer golfer = new Golfer(data[0], data[1], data[2]);
                for (int i = 0; i < 4; i++) {
                    golfer.setScore(i, Integer.parseInt(data[i + 3]));
                }
                golfers.add(golfer);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveGolfers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Golfer golfer : golfers) {
                bw.write(golfer.getId() + "," + golfer.getFirstName() + "," + golfer.getLastName());
                for (int i = 0; i < 4; i++) {
                    bw.write("," + golfer.getScore(i));
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add a new golfer");
            System.out.println("2. Update a golfer's score");
            System.out.println("3. Display golfer list");
            System.out.println("4. Show the leader board");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Golfer ID: ");
                    String id = scanner.next();
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.next();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.next();
                    addGolfer(new Golfer(id, firstName, lastName));
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter Golfer ID: ");
                    id = scanner.next();
                    System.out.print("Enter round (0-3): ");
                    int round = scanner.nextInt();
                    System.out.print("Enter score: ");
                    int score = scanner.nextInt();
                    updateScore(id, round, score);
                    System.out.println();
                    break;
                case 3:
                    displayGolfers();
                    break;
                case 4:
                    showLeaderboard();
                    break;
                case 5:
                    saveGolfers();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        GolfTournament tournament = new GolfTournament();
        tournament.showMenu();
    }
}


/*
Name - Soe Min Min Lstt
ID - 6611938
Sec - 541
 */
package Week07;

import java.util.ArrayList;
import java.util.Scanner;

class Students {
    private String ID;
    private String fName;
    private String lname;
    private int score;

    public Students(){
        this.ID = "9999999";
        this.fName = "Unnamed";
        this.lname = "Unnamed";
        this.score = 0;
    }

    public Students(String ID, String fName, String lname, int score){
        this.ID = ID;
        this.fName = fName;
        this.lname = lname;
        this.score = score;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getScore() {
        return score;
    }

    public boolean setScore(int score) {
        if (score < 0 || score > 100) {
            return false;
        } else {
            this.score = score;
            return true;
        }
    }
    @Override
    public String toString() {
        return "ID: " + ID + ", First Name: " + fName + ", Last Name: " + lname + ", Score: " + score;
    }
}
public class StudentRecordManager {
    public static void addStudent(){
        System.out.print("Enter student ID: ");
        String newID = reader.nextLine();
        System.out.print("Enter student firstname: ");
        String newfname = reader.nextLine();
        System.out.print("Enter student lastname: ");
        String newlname = reader.nextLine();
        System.out.print("Enter score: ");
        int newscore = reader.nextInt();
        reader.nextLine();

        students.add(new Students(newID, newfname, newlname, newscore));
        System.out.println("Successful!");
    }
    public static void modifyStudent(){
        System.out.print("Enter ID to modify: ");
        String modifyID = reader.nextLine();
        for (Students students: students){
            if(students.getID().equals(modifyID)){
                System.out.print("Enter new first name: ");
                String firstName = reader.nextLine();
                System.out.print("Enter new last name: ");
                String lastName = reader.nextLine();
                System.out.print("Enter new score: ");
                int score = reader.nextInt();
                reader.nextLine();

                students.setfName(firstName);
                students.setLname(lastName);
                students.setScore(score);
                System.out.println("Successful!");
            }
        }
    }
    public static void deleteStudent(){
        System.out.print("Enter student ID to delete: ");
        String id = reader.nextLine();
        for (Students students : students){
            if(students.getID().equals(id)){
                students.setID("9999999");
                System.out.println("Successful!");
            }
        }
    }
    public static void display(){
        for (Students students: students){
            if(!students.getID().equals("9999999")){
                System.out.println(students);
            }
        }
    }

    private static ArrayList<Students> students = new ArrayList<>();
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        boolean exit = true;
        System.out.println("1. Add a new student");
        System.out.println("2. Modify student's information");
        System.out.println("3. Delete a student");
        System.out.println("4. Display the list of students");
        System.out.println("5. Exit");
        while (exit) {
            System.out.print("Enter your choice[1-5]: ");
            choice = reader.nextInt();
            reader.nextLine();
            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                modifyStudent();
            } else if (choice == 3) {
                deleteStudent();
            } else if (choice == 4) {
                display();
                break;
            } else if (choice == 5) {
                exit = false;
            } else {
                System.out.println("Choose 1-5 to continue.");
            }
        }
    }
}

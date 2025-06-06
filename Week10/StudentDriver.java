//package Week10;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class StudentDriver {
//    private ArrayList<Students> students;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int option = 0;
//        while (option != 3){
//            System.out.println("1. Add a new student: ");
//            System.out.println("2. List al students: ");
//            System.out.println("3. Exit the program: ");
//            System.out.print("Enter your option: ");
//            option = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (option){
//                case 1:
//                    System.out.print("Enter the ID: ");
//                    String id = scanner.nextLine();
//                    System.out.print("Enter the first name: ");
//                    String firstName = scanner.nextLine();
//                    System.out.println("Enter the last name: ");
//                    String lastName = scanner.nextLine();
//                    System.out.print("Enter the score: ");
//                    int score = scanner.nextInt();
//                    addStudent(aStudent);
//            }
//        }
//    }
//    public static void addStudent(Student s){
//        students.add(s);
//    }
//    public static void listStudents(){
//        for (Student s : students){
//            System.out.println(s);
//        }
//    }
//}

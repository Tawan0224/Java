package Week06;

import Week05.Student;

public class ParameterPassingExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.println("Before calling swap() method");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        swap(a, b);
        System.out.println("After calling swap() method");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        Student aStudent = new Student("6621111", "Homer", "Simpson");
        System.out.println("\nBefore calling tryObject() method");
        System.out.println(aStudent);
        System.out.println("After calling tryObject() method");
        tryObject(aStudent);
        System.out.println(aStudent);

        Student snoopy = new Student();
        snoopy.setFirstName("Snoopy");
        System.out.println("\nBefore calling createStudent() method");
        System.out.println(snoopy);
        createStudent(snoopy, "Chase", "Paw Patrol");
        System.out.println("After calling createStudent() method");
        System.out.println(snoopy);

        int[] numbers = {1, 3, 5, 7, 9, 11};
        System.out.println("\nBefore calling addN() method");
        printArray(numbers);
        addN(numbers, 5);
        System.out.println("After calling addN() method");
        printArray(numbers);

        int[] evenNumbers = {2, 4, 6, 8, 10, 12, 14};
        System.out.println("\nBefore calling justAdd() method");
        printArray(evenNumbers);
        for (int i = 0; i < evenNumbers.length; ++i) {
            justAdd(evenNumbers[i], 10);
        }
        System.out.println("After calling justAdd() method");
        printArray(evenNumbers);
    }

    public static void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    public static void tryObject(Student s) {
        s.setFirstName("Fred");
        s.setLastName("Flintstone");
    }

    public static void createStudent(Student s, String fName, String lName) {
        s = new Student();
        s.setFirstName(fName);
        s.setLastName(lName);
    }

    public static void addN(int[] array, int n) {
        for (int i = 0; i < array.length; ++i) {
            array[i] += n;
        }
    }

    public static void justAdd(int number, int x) {
        number += x;
    }

    public static void printArray(int[] array) {
        System.out.print("[ ");

        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }
}
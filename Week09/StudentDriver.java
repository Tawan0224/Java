/*
Name - Soe Min Min Latt
ID - 6611938
Sec - 541
 */
package Week09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentDriver {
    public static void main(String[] args) {
        File studentFile = new File("student.csv");
        try {
            Scanner fileReader = new Scanner(studentFile);

            while (fileReader.hasNext()) {
                String buffer = fileReader.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(buffer, ",");

                String type = tokenizer.nextToken();
                String firstName = tokenizer.nextToken();
                String lastName = tokenizer.nextToken();

                Student student;
                if (type.equals("G")) {
                    student = new GraduateStudent(firstName, lastName);
                } else {
                    student = new UndergraduateStudent(firstName, lastName);
                }

                int testNumber = 1;
                while (tokenizer.hasMoreTokens() && testNumber <= Student.NUM_TEST) {
                    int score = Integer.parseInt(tokenizer.nextToken());
                    student.setTestScore(testNumber, score);
                    testNumber++;
                }
                System.out.printf("%s, %s %s, %d, %s%n",
                        student.getType(), student.getFirstName(), student.getLastName(),
                        student.getTotalScore(), student.calculateGrade());
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
        }
    }
}

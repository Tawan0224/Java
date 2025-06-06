/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week08.NonCreditCourseGrading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NonCreditCourseGrading {

    public static void main(String[] args) {
        File nonCreditFile = new File("NonCreditCourseGrading.csv");

        try {
            Scanner fileReader = new Scanner(nonCreditFile);
            Student[] students = new Student[20];
            int count = 0;

            while (fileReader.hasNext()) {
                String type;
                String fName;
                String lName;
                int[] scores = new int[3];

                String buffer = fileReader.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(buffer, ",");
                type = tokenizer.nextToken();
                fName = tokenizer.nextToken();
                lName = tokenizer.nextToken();
                for (int i = 0; i < 3; i++) {
                    scores[i] = Integer.parseInt(tokenizer.nextToken());
                }

                if (type.equalsIgnoreCase("G")) {
                    students[count] = new GraduateStudent(fName, lName, scores);
                    count++;
                } else if (type.equalsIgnoreCase("U")) {
                    students[count] = new UndergraduateStudent(fName, lName, scores);
                    count++;
                }
            }

            fileReader.close();

            for (int i = 0; i < count; ++i) {
                System.out.println(students[i]);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found!!");
        }
    }
}

package Week08.Student;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileProcessingSample {

    public static void main(String[] args) {
        File studentFile = new File("students.csv");

        try {
            Scanner fileReader = new Scanner(studentFile);
            Student[] students = new Student[20];
            int count = 0;

            while (fileReader.hasNext()) {
                String type;
                String id;
                String fName;
                String lName;
                int score;

                String buffer = fileReader.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(buffer, ",");
                type = tokenizer.nextToken();
                id = tokenizer.nextToken();
                fName = tokenizer.nextToken();
                lName = tokenizer.nextToken();
                score = Integer.parseInt(tokenizer.nextToken());

                if (type.equalsIgnoreCase("G")) {
                    students[count] = new GraduateStudent(id, fName, lName);
                    students[count].setScore(score);
                    count++;
                } else if (type.equalsIgnoreCase("U")) {
                    students[count] = new UndergraduateStudent(id, fName, lName);
                    students[count].setScore(score);
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

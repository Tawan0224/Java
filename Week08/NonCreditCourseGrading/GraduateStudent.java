/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week08.NonCreditCourseGrading;

public class GraduateStudent extends Student {
    public GraduateStudent(String firstName, String lastName, int[] scores) {
        super(firstName, lastName, scores);
    }

    @Override
    public String calculateGrade() {
        if (getAverageScore() >= 90) {
            return "S";
        } else {
            return "U";
        }
    }
}

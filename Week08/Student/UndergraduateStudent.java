package Week08.Student;

public class UndergraduateStudent extends Student {

    public UndergraduateStudent(String id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    @Override
    public String calculateGrade() {
        if (getScore() >= 70) {
            return  "S";
        } else {
            return  "U";
        }
    }

}

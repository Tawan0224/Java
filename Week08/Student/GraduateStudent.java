package Week08.Student;

public class GraduateStudent extends Student {
    public GraduateStudent(String id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    @Override
    public String calculateGrade() {
        if (getScore() >= 90) {
            return "S";
        } else {
            return "U";
        }
    }
}

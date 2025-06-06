package Week08.Student;

abstract public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private int score;

    public Student() {
        this.id = "9999999";
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.score = 0;
    }
    public Student(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName =  firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getScore() {
        return score;
    }

    public boolean setScore(int score) {
        if (score < 0 || score > 100) {
            return false;
        } else {
            this.score =  score;
            return true;
        }
    }

    abstract public String calculateGrade();

    @Override
    public String toString() {
        return String.format("%s %s %s", firstName, lastName, calculateGrade());
    }
}

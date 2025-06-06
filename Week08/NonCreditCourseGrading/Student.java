/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week08.NonCreditCourseGrading;

abstract public class Student {
    private String firstName;
    private String lastName;
    private int[] scores;

    public Student(String firstName, String lastName, int[] scores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.scores = scores;
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

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public double getAverageScore() {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum / (double) scores.length;
    }

    abstract public String calculateGrade();

    @Override
    public String toString() {
        return String.format("%s %s %s", firstName, lastName, calculateGrade());
    }
}
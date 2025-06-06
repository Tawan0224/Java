/*
Name - Soe Min Min Latt
ID - 6611938
Sec - 541
 */
package Week09;

abstract public class Student {
    private String firstName;
    private String lastName;
    private int[] testScores;

    public final static int NUM_TEST = 5;

    public Student(){
        this.firstName = "Unnamed";
        this.lastName = "Unnamed";
        this.testScores = new int[NUM_TEST];
    }

    public Student(String fName, String lName){
        this.firstName = fName;
        this.lastName = lName;
        this.testScores = new int[NUM_TEST];
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTestScore(int testNumber){
        return testScores[testNumber - 1];
    }

    public boolean setTestScore(int testNumber, int score){
        if (score < 0 || score > 20){
            return false;
        }else{
            testScores[testNumber - 1] = score;
            return true;
        }
    }

    public int getTotalScore(){
        int total = 0;
        for (int i = 0; i < NUM_TEST; i++) {
            total += testScores[i];
        }
        return total;
    }
    abstract public String calculateGrade();
    abstract public String getType();

    public String toCSV(){
        return String.format("%s,%s,%s,%d,%d,%d,%d,%d",
                                this.getType(),
                                this.firstName,
                                this.lastName,
                                this.testScores[0],
                                this.testScores[1],
                                this.testScores[2],
                                this.testScores[3],
                                this.testScores[4],
                                this.testScores[5]);
    }

    @Override
    public String toString() {
        return null;
    }
}

/*
Name - Soe Min Min Latt
ID - 6611938
Sec - 541
 */
package Week09;

public class UndergraduateStudent extends Student{
    public UndergraduateStudent() {
        super();
    }

    public UndergraduateStudent(String fName, String lName) {
        super(fName, lName);
    }

    @Override
    public String calculateGrade() {
        if(getTotalScore() > 85){
            return "A";
        } else if (getTotalScore() >= 75) {
            return "B";
        } else if (getTotalScore() >= 60){
            return "C";
        } else if (getTotalScore() >= 50){
            return "D";
        }else{
            return "F";
        }
    }

    @Override
    public String getType() {
        return "U";
    }
}

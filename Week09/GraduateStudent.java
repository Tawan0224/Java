/*
Name - Soe Min Min Latt
ID - 6611938
Sec - 541
 */
package Week09;

public class GraduateStudent extends Student{
    public GraduateStudent() {
        super();
    }

    public GraduateStudent(String fName, String lName) {
        super(fName, lName);
    }

    @Override
    public String calculateGrade() {
        if (getTotalScore() >= 80){
            return "S";
        }else {
            return "U";
        }
    }

    @Override
    public String getType() {
        return "G";
    }
}

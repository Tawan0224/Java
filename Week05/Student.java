package Week05;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String major;
    private int score;

    // default constructor
    public Student(){
        this. id = "9999999";
        this.firstName = "Unnamed";
        this.lastName = "Unnamed";
        this.major = "Non";
        this.score = 0;
    }
    public Student(String id, String fName, String lName){
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.major = "Non-Major";
        this.score = 0;
    }


    public String getId(){
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getScore() {
        return this.score;
    }

    public boolean setScore(int score) {
        if (score < 0 || score > 100){
            return false;
        }else {
            this.score = score;
            return true;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d", this.id, this.firstName, this.lastName, this.major, this.score);
    }
}

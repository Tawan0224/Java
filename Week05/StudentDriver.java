package Week05;

public class StudentDriver{
    public static void main(String[] args) {
        Student tawan = new Student("6611938", "Tawan", "M.");
        System.out.println(tawan.getFirstName()+ " " + tawan.getLastName() + "\n" + tawan.getId());

        tawan.setMajor("CS");
        System.out.println(tawan.getMajor());
        System.out.println(tawan);
    }
}

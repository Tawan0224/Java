/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week05;

public class MyTimeDriver {
    public static void main(String[] args) {
        MyTime defaultTime = new MyTime();
        System.out.println("Default time (24-hour): " + defaultTime.to24HourFormat());
        System.out.println("Default time (24-hour): " + defaultTime.to12HourFormat());
        System.out.println();

        MyTime time1 = new MyTime(13,5,58);
        System.out.println("Time-1 (24-hour): " + time1.to24HourFormat());
        System.out.println("Time-1 (24-hour): " + time1.to12HourFormat());
        System.out.println();

        MyTime time2 = new MyTime(12, 5, 14);
        System.out.println("Time-2 (24-hour): " + time2.to24HourFormat());
        System.out.println("Time-2 (12-hour): " + time2.to12HourFormat());
        System.out.println();

        MyTime time3 = new MyTime(0, 0, 0);
        System.out.println("Time-3 (24-hour): " + time3.to24HourFormat());
        System.out.println("Time-3 (12-hour): " + time3.to12HourFormat());
        System.out.println();

        MyTime time4 = new MyTime(9, 15);
        System.out.println("Time-4 (24-hour): " + time4.to24HourFormat());
        System.out.println("Time-4 (12-hour): " + time4.to12HourFormat());
        System.out.println();

        MyTime time5 = new MyTime(21);
        System.out.println("Time-5 (24-hour): " + time5.to24HourFormat());
        System.out.println("Time-5 (12-hour): " + time5.to12HourFormat());
        System.out.println();
    }
}

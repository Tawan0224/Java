/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */

package Week05;

public class MyTime {
    private int hour;
    private int minute;
    private int second;

    public MyTime() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public MyTime(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public MyTime(int hour, int minute) {
        this(hour, minute, 0);
    }

    public MyTime(int hour) {
        this(hour, 0, 0);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour < 24) {
            this.hour = hour;
        }
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute < 60) {
            this.minute = minute;
        }
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second >= 0 && second < 60) {
            this.second = second;
        }
    }

    public String to12HourFormat() {
        String period = (hour < 12) ? "AM" : "PM";
        int hour12 = (hour % 12 == 0) ? 12 : hour % 12;
        return String.format("%02d:%02d:%02d %s", hour12, minute, second, period);
    }
    public String to24HourFormat() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}

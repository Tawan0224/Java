/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week08.Golf;

public class Golfer {
    private String id;
    private String firstName;
    private String lastName;
    private int[] scores;

    public Golfer(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.scores = new int[4];
    }

    public String getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getScore(int round) {
        return scores[round];
    }
    public void setScore(int round, int score) {
        this.scores[round] = score;
    }

    public int getTotalScore() {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    public String getFormattedTotalScore() {
        int totalScore = getTotalScore();
        int par = 72 * 4; // Assuming par 72 for each round
        int diff = totalScore - par;
        if (diff == 0) {
            return "even";
        } else if (diff > 0) {
            return diff + " over";
        } else {
            return -diff + " under";
        }
    }
}


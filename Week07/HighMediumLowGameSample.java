package Week07;

public class HighMediumLowGameSample {
    public static void main(String[] args) {
        Dice[] dices = new Dice[3];

        dices[0] = new Dice();
        dices[1] = new Dice();
        dices[2] = new Dice();

        int sum = 0;

        for (Dice d:dices) {
            System.out.println(d.getFaceValue());
            sum += d.getFaceValue();
        }

        if (sum >= 13) {
            System.out.println("High");
        } else if (sum >= 7) {
            System.out.println("Medium");
        } else {
            System.out.println("Low");
        }

    }
}

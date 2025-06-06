/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week07;

import java.util.Scanner;

public class HighMediumLowGame {
    public static void main(String[] args) {
        Dice[] dice = new Dice[3];

        dice[0] = new Dice();
        dice[1] = new Dice();
        dice[2] = new Dice();
        int i = 1;
        int win = 0;
        int lose = 0;

        boolean con = true;
        while (con){
            System.out.println("Game " + i);
            System.out.println("==================");
            int sum = 0;
            for (int j = 0; j < 1; j++) {
                System.out.println("The first dice: " + dice[j].getFaceValue());
                sum += dice[j].getFaceValue();
            }
            for (int j = 1; j < 2; j++) {
                System.out.println("The second dice: " + dice[j].getFaceValue());
                sum += dice[j].getFaceValue();
            }
            System.out.println("High is between 13 and 18");
            System.out.println("Medium is between 7 and 12");
            System.out.println("Low is between 1 and 6");

            Scanner reader = new Scanner(System.in);
            System.out.print("Enter your guess [H, M, L]: ");
            String ans = reader.nextLine();

            for (int j = 2; j < 3; j++) {
                System.out.println("The third dice: " + dice[j].getFaceValue());
                sum += dice[j].getFaceValue();
            }
            System.out.println("The sum is: " + sum);

            if ((sum >= 13 && sum <= 18 && ans.equals("H")) || (sum >= 7 && sum <= 12 && ans.equals("M")) || (sum >= 3 && sum <= 6 && ans.equals("L"))) {
                System.out.println("You are correct.");
                win++;
            } else {
                System.out.println("You are incorrect.");
                lose++;
            }
            Scanner yn = new Scanner(System.in);
            System.out.print("Do you want to continue [Y/N]: ");
            String want = yn.nextLine();
            if(want.equals("Y")){
                con = true;
            }else if (want.equals("N")){
                System.out.println("==================");
                System.out.println("Game Stats");
                System.out.println("==================");
                System.out.println("Win - " + win + "(" + (win * 100 / i) + "%)");
                System.out.println("Lose - " + lose + "(" + (lose * 100 / i) + "%)");
                con = false;
            }
            System.out.println();
            i++;
        }
    }
}

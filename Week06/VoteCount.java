/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week06;

import java.util.Scanner;

public class VoteCount {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("How many candidates?");
        int candidates = reader.nextInt();

        System.out.println("How many voters?");
        int voters = reader.nextInt();

        int[] votes = new int[candidates+1];
        System.out.println("Type the voting results:");
        for (int i = 0; i < voters; i++) {
            int result = reader.nextInt();
            votes[result]++;
        }

        int maxVotes = 0;
        for (int i = 1; i <= candidates; i++) {
            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
            }
        }
        System.out.print("Winners: ");
        for (int i = 1; i <= candidates; i++) {
            if (votes[i] == maxVotes) {
                System.out.print(i + " ");
            }
        }
        reader.close();
    }
}


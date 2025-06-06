/*
Name - Soe Min Min Latt
ID - 6611938
Sec - 541
 */
package Week10;
import java.util.Random;
import java.util.Scanner;

class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

class Deck {
    private Card[] cards;
    private Random random;

    public Deck() {
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        cards = new Card[52];
        random = new Random();

        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                cards[index++] = new Card(suit, rank);
            }
        }
    }

    public Card dealCard() {
        int index = random.nextInt(52);
        return cards[index];
    }
}

public class CardGuessingGame {
    private Deck deck;
    private Scanner scanner;
    private int totalGamesPlayed;
    private int wins;

    public CardGuessingGame() {
        deck = new Deck();
        scanner = new Scanner(System.in);
        totalGamesPlayed = 0;
        wins = 0;
    }

    public void play() {
        boolean playAgain = true;

        while (playAgain) {
            totalGamesPlayed++;
            Card choose = deck.dealCard();

            System.out.println(":: Game " + totalGamesPlayed + " ::");
            System.out.println("Please select the rank of the card.");
            System.out.println("(1=Ace, 2=Two,…, 10=Ten, 11=Jack, 12=Queen, 13=King): ");
            int rankChoice = scanner.nextInt();

            System.out.println("Please select the suit of the card.");
            System.out.println("(1=Spades, 2=Hearts, 3=Diamonds, 4=Clubs): ");
            int suitChoice = scanner.nextInt();

            String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
            String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

            String selectedSuit = suits[suitChoice - 1];
            String selectedRank = ranks[rankChoice - 1];

            boolean correctGuess = false;
            int attempts = 0;

            while (attempts < 5 && !correctGuess) {
                attempts++;

                if (selectedRank.equals(choose.getRank()) && selectedSuit.equals(choose.getSuit())) {
                    correctGuess = true;
                    wins++;
                    System.out.println("You won!! You picked the right card.");
                } else if (!selectedRank.equals(choose.getRank()) && !selectedSuit.equals(choose.getSuit())) {
                    System.out.println("Wrong suit, wrong rank!! Pick again.");
                } else if (selectedRank.equals(choose.getRank())) {
                    System.out.println("Wrong suit, correct rank!! Pick again.");
                } else {
                    System.out.println("Right suit, wrong rank!! Pick again.");
                }

                if (!correctGuess && attempts < 5) {
                    System.out.println("Please select the rank of the card.");
                    rankChoice = scanner.nextInt();

                    System.out.println("Please select the suit of the card.");
                    suitChoice = scanner.nextInt();

                    selectedSuit = suits[suitChoice - 1];
                    selectedRank = ranks[rankChoice - 1];
                }
            }

            if (!correctGuess) {
                System.out.println("Right suit, wrong rank!! You’ve run out of tries.");
                System.out.println("You lost!! I chose " + choose + ".");
            }

            System.out.print("Do you want to play again [Y/N]? ");
            char response = scanner.next().charAt(0);
            playAgain = (response == 'Y' || response == 'y');
        }

        gameResult();
    }

    private void gameResult() {
        System.out.println("Total games played: " + totalGamesPlayed);
        System.out.println("Win : " + wins + " (" + (wins * 100 / totalGamesPlayed) + "%)");
        System.out.println("Loss: " + (totalGamesPlayed - wins) + " (" + ((totalGamesPlayed - wins) * 100 / totalGamesPlayed) + "%)");
    }

    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("            CARD GUESSING v1.0");
        System.out.println("=============================================");
        CardGuessingGame game = new CardGuessingGame();
        game.play();
    }
}

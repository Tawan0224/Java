/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week07;

import java.util.Scanner;

public class NGramExtractor {
    String[] extractNGrams(String text, int n){
        String[] words = text.toLowerCase().split(" ");
        int numNGrams = words.length - n + 1;
        if (numNGrams <= 0) {
            return new String[0];
        }

        String[] nGrams = new String[numNGrams];
        for (int i = 0; i < numNGrams; i++) {
            StringBuilder nGram = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j > 0) nGram.append(" ");
                nGram.append(words[i + j]);
            }
            nGrams[i] = nGram.toString();
        }
        return nGrams;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text:");
        String text = scanner.nextLine();

        System.out.println("Enter the value of n:");
        int n = scanner.nextInt();

        NGramExtractor extractor = new NGramExtractor();
        String[] nGrams = extractor.extractNGrams(text, n);

        System.out.print("[");
        for (int i = 0; i < nGrams.length; i++) {
            System.out.print("\"" + nGrams[i] + "\"");
            if (i < nGrams.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        scanner.close();
    }
}

/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week13;

import java.util.Scanner;
public class BaseConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal: ");
        int decimal = scanner.nextInt();
        System.out.print("Enter a base: ");
        int base = scanner.nextInt();

        String result = convertToBase(decimal, base);
        System.out.println("The base "+ base + " of " + decimal + " is " + result);
    }

    public static String convertToBase(int decimal, int base) {
        String digits = "0123456789ABCDEF";
        String result = "";

        while (decimal > 0) {
            int remainder = decimal % base;
            result = digits.charAt(remainder) + result;
            decimal = decimal / base;
        }

        return result;
    }
}

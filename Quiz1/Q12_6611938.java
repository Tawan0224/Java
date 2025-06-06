/*
Name - Soe Min Min Latt
ID - 6611938
Sec - 541
 */
package Quiz1;

public class Q12_6611938 {
    public static String splitTwin(String str){
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i);
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                result += '*';
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.printf("%s -----> %s\n", "hello", splitTwin("hello"));
        System.out.printf("%s -----> %s\n", "ooooooo", splitTwin("ooooooo"));
        System.out.printf("%s -----> %s\n", "AAABBBCCC", splitTwin("AAABBBCCC"));
        System.out.printf("%s -----> %s\n", "ABCDEF", splitTwin("ABCDEF"));
    }
}

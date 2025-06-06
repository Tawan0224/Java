/*
Name - Soe Min Min Latt
ID - 6611938
Sec - 541
 */
package Quiz1;

public class Q11_6611938 {
    public static int[] sequenceThisPattern(int n ){
        int totalLength = (n * (n + 1)) / 2;
        int[] result = new int[totalLength];
        int index = 0;
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                result[index++] = j;
            }
        }
        return result;
    }
    public static void printArray(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length-1] + "] ");
    }

    public static void main(String[] args) {
        for (int i = 1; i <=5; i++) {
            printArray(sequenceThisPattern(i));
        }
    }
}

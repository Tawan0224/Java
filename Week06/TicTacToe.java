/*
Name - Soe Min Min Latt
Sec - 541
ID - 6611938
 */
package Week06;

public class TicTacToe {
    public static char judge(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return board[i][0];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return board[0][i];
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return board[0][2];
        }
        return 'D';
    }
    public static void main(String[] args) {
        char[][] game1 = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'O', 'X', 'X'}
        };
        System.out.println("Game 1 result: ");
        for (int i = 0; i < game1.length; i++) {
            for (int j = 0; j < game1[i].length; j++) {
                System.out.print(game1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Game 1 winner - " + judge(game1));
        System.out.println();

        char[][] game2 = {
                {'X', 'O', 'X'},
                {'O', 'O', 'O'},
                {'X', 'X', 'O'}
        };
        System.out.println("Game 2 result: ");
        for (int i = 0; i < game2.length; i++) {
            for (int j = 0; j < game2[i].length; j++) {
                System.out.print(game2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Game 2 winner - " + judge(game2));
        System.out.println();

        char[][] game3 = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'O', 'X', 'O'}
        };
        System.out.println("Game 3 result: ");
        for (int i = 0; i < game1.length; i++) {
            for (int j = 0; j < game3[i].length; j++) {
                System.out.print(game3[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Game 3 winner - " + judge(game3));
    }
}


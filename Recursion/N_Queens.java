package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class N_Queens {

    public static boolean isSafe(char[][] chess, int row, int col) {
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void printQueens(int row, char[][] chess, List<List<String>> res) {
        if (row >= chess.length) {
            res.add(construct(chess));
            return;
        }
        for (int col = 0; col < chess.length; col++)
            if (isSafe(chess, row, col)) {
                chess[row][col] = 'Q';
                printQueens(row + 1, chess, res);
                chess[row][col] = '.';
            }
    }

    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        printQueens(0, board, res);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> queen = solveNQueens(n);
        System.out.println(queen.size());
    }
}

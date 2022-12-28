package Masai;

import java.util.Scanner;

public class Where_IS_Bishop {
    public static int[] findBishop(int[][] chessboard) {
        // Iterate through the rows and columns of the chessboard
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                // Check whether the cell (i, j) is attack by the bishop
                if (chessboard[i][j] == 1) {
                    // Check whether the cell (i + 1, j + 1) or the cell (i + 1, j - 1) is also attack
                    if (chessboard[i + 1][j + 1] != 1 && chessboard[i + 1][j - 1] != 1) {
                        // The bishop is placed on this cell
                        return new int[] {i, j};
                    }
                }
            }
        }
        return new int[] {-1, -1};  // The bishop is not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0){
            int[][] mat= new int[8][8];
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    mat[i][j]= sc.nextInt();
                }
            }
            System.out.println(findBishop(mat));
        }
    }
}

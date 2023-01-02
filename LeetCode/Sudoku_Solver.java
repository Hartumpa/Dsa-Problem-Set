package LeetCode;

public class Sudoku_Solver {

    private static boolean isSafe(int r, int c,char[][] board, int val){
        for (int i=0;i<9;i++) {
            if (board[r][i] == val) {
                return false;
            }

            if (board[i][c] == val) {
                return false;
            }

            if (board[3 * (r / 3) + i / 3][3*(c/3)+i%3]==val){
                return false;
            }
        }
        return true;
    }

    public static boolean solveSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char val='1';val<='9';val++){
                        if(isSafe(i,j,board,val)) {
                            board[i][j] = val;
                            boolean ans = solveSudoku(board);
                            if (ans) {
                                return true;
                            } else {
                                board[i][j] = '.'; // backtrack
                            }
                        }
                    }
                    return false; // if any value we not get
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        if(solveSudoku(board)){
            for (int i=0;i<9;i++){
                for (int j=0;j<9;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}

package Masai;

import java.util.Scanner;

public class Bishop_Attack {

    public static int maximalSum(int[][] grid) {
        int maxSum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int sum = grid[i][j];
                int x = i - 1;
                int y = j - 1;
                while (x >= 0 && y >= 0) {
                    sum += grid[x][y];
                    x--;
                    y--;
                }
                x = i - 1;
                y = j + 1;
                while (x >= 0 && y < grid[0].length) {
                    sum += grid[x][y];
                    x--;
                    y++;
                }
                x = i + 1;
                y = j - 1;
                while (x < grid.length && y >= 0) {
                    sum += grid[x][y];
                    x++;
                    y--;
                }
                x = i + 1;
                y = j + 1;
                while (x < grid.length && y < grid[0].length) {
                    sum += grid[x][y];
                    x++;
                    y++;
                }
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0){
            int n= sc.nextInt();
            int m= sc.nextInt();
            int mat[][]=new int[n][m];
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    mat[i][j]= sc.nextInt();
                }
            }
        }
    }

//    public static int sumProperNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int sum = 0;
//        if (root.left != null && root.right != null) {
//            sum += root.val;
//        }
//
//        return sum + sumProperNodes(root.left) + sumProperNodes(root.right);
//    }

}


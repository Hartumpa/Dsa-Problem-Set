package Dynamic_Programming;

import java.util.Arrays;

public class Unique_paths {
    public static int unique(int m, int n,int dp[][]){
        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int up = unique(m-1,n,dp);
        int left = unique(m,n-1,dp);
        return dp[m][n]= up+left;
    }
    public static int uniquePaths(int m, int n) {
        int dp[][]=new int[m-1][n-1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return unique(m-1,n-1,dp);
    }
}

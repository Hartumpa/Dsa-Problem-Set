package Strings;

import java.util.Arrays;

public class Longest_Common_Subsequences {

//    public static  int solve(int i1,int i2,String text1, String text2){
//
//        if(i1<0 || i2<0){
//            return 0;
//        }
//
//        if(text1.charAt(i1)==text2.charAt(i2)){
//            return 1+solve(i1-1,i2-1,text1,text2);
//        }
//        return Math.max(solve(i1-1,i2,text1,text2),solve(i1,i2-1,text1,text2));
//    }

//    public static  int memoization(int i1,int i2,String text1, String text2,int dp[][]){
//
//        if(i1<0 || i2<0){
//            return 0;
//        }
//
//        if(dp[i1][i2]!=-1){
//            return dp[i1][i2];
//        }
//
//        if(text1.charAt(i1)==text2.charAt(i2)){
//            return 1+memoization(i1-1,i2-1,text1,text2,dp);
//        }
//        return  dp[i1][i2]= Math.max(memoization(i1-1,i2,text1,text2,dp),memoization(i1,i2-1,text1,text2,dp));
//    }

//    public static int longestCommonSubsequence(String text1, String text2) {
//        int n=text1.length();
//        int m=text2.length();
//        int dp[][]=new int[n+1][m+1];
//        for(int i=0;i<=n;i++){
//            dp[i][0] = 0;
//        }
//        for(int i=0;i<=m;i++){
//            dp[0][i] = 0;
//        }
//        for (int i=1;i<=n;i++){
//            for(int j=1;j<=m;j++){
//                if (text1.charAt(i) == text2.charAt(j)) {
//                    dp[i][j]=1+dp[i-1][j-1];
//                }else
//                 dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
//            }
//        }
//        return dp[n][m];
//
//    }


    public static int longestCommonSubsequenceSpace(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int prev[] = new int[m + 1];
        int cur[] = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    cur[j] = 1 + prev[j - 1];
                } else
                    cur[j] = Math.max(prev[j], cur[j - 1]);
            }
            prev=cur;
        }
        return prev[m];

    }

    static void lcsPrint(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }

        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }

        int len=dp[n][m];
        int i=n;
        int j=m;

        int index = len-1;
        String str="";
        for(int k=1; k<=len;k++){
            str +="$"; // dummy string
        }
        StringBuilder ss= new StringBuilder(s1);
        StringBuilder str2=new StringBuilder(str);
        while(i>0 && j>0){
            if(ss.charAt(i-1) == s2.charAt(j-1)){
                str2.setCharAt(index,ss.charAt(i-1) );
                index--;
                i--;
                j--;
            }
            else if(ss.charAt(i-1)>s2.charAt(j-1)){
                i--;
            }
            else j--;
        }
        System.out.println(str2);
    }


    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        System.out.println(longestCommonSubsequenceSpace(str1, str2));
    }
}

import java.util.*;
import java.io.*;

public class Main {


    public static int solve(int ind, int target, int arr[]){

        if(ind==0){
            if(target % arr[0]==0){
                return target/arr[0];
            }
            else{
                return (int)Math.pow(10,9);
            }
        }

        int notPick=0+solve(ind-1,target,arr);
        int pick=(int)Math.pow(10,9);
        if(arr[ind]<=target)
            pick=1+solve(ind,target-arr[ind],arr);
        return Math.min(pick,notPick);
    }

    public static int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int ans= solve(n-1,amount,coins);
        if(ans >= (int)Math.pow(10,9)) return -1;
        return ans;
    }

//    public static int solve(int k,int dp[]) {
//        if (k == 0) {
//            return 1;
//        }
//        if (k < 0) {
//            return (int)(1e6);
//        }
//        if(dp[k]!=-1){
//            return dp[k];
//        }
//        int pick10 =1+solve(k - 10,dp);
//        int pick12 =1+solve(k - 12,dp);
//
//        return dp[k]= Math.min(pick10 ,pick12);
//    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {

            int n = sc.nextInt();
            int arr[]={10,12};

            System.out.println(coinChange(arr,n));

        }
    }


}
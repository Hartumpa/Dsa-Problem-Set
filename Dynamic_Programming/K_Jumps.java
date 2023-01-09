package Dynamic_Programming;

import java.util.Arrays;

public class K_Jumps {


    // recursion method
    private static int recursion(int ind, int arr[], int k){
        if(ind==0){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for (int i=1;i<=k;i++){
            if((ind-i)>=0){
                int x=recursion(ind-i,arr,k)+Math.abs(arr[ind]-arr[ind-i]);
                min=Math.min(min,x);
            }
        }
        return min;
    }

    // Memoization Approach

    private static int memoization(int ind, int arr[], int k,int dp[]){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int mmSteps = Integer.MAX_VALUE;

        for(int j=1;j<=k;j++){
            if(ind-j>=0){
                int jump = memoization(ind-j, arr, k,dp)+ Math.abs(arr[ind]-
                        arr[ind-j]);
                mmSteps= Math.min(jump, mmSteps);
            }
        }
        return dp[ind]= mmSteps;
    }

    // Tabulation Approach

    private static int tabulation(int n, int arr[], int k,int dp[]){
        dp[0]=0;
        for (int i=1;i<n;i++){
            int mmSteps = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int jump = dp[i-j]+ Math.abs(arr[i]-
                            arr[i-j]);
                    mmSteps= Math.min(jump, mmSteps);
                }
            }
            dp[i]= mmSteps;
        }
        return dp[n-1];
    }

    private static int solve(int n, int arr[], int k){
//       return recursion(n-1,arr,k);
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
//        return memoization(n-1,arr,k,dp);
        return tabulation(n,arr,k,dp);
    }

    public static void main(String args[]) {

        int height[]={30,10,60 , 10 , 60 , 50};
        int n=height.length;
        int k=2;
        System.out.println(solve(n,height,k));
    }
}

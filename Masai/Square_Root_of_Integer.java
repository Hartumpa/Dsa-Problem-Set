package Masai;

import java.util.Scanner;

public class Square_Root_of_Integer {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();


            System.out.println(solve(n));
        }
    }

    public  static  long solve(int n){
        long l=1,r=n;
        long ans=-1;
        while(l<=r){
            long mid= l+(r-l)/2;
            if(mid*mid==n){
                return mid;
            } else if (mid*mid<n) {
                ans=mid;
                l=mid+1;

            }else{
                r=mid-1;
            }
        }
        return ans;
    }
}

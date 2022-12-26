package Recursion;

import java.util.Scanner;

public class Power {
    private  static  int power(int a, int b){
        if(b==0){
            return 1;
        }
        if(b==1){
            return a;
        }
        if(b%2==0){
            return power(a,b/2)*power(a,b/2);
        }else {
            return a*power(a,b/2)*power(a,b/2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ans=power(a,b);
        System.out.println("Power of a to b is :"+ans);
    }
}


package Masai;

import java.util.Arrays;
import java.util.Scanner;

public class Product_Itself {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0){
            int n= sc.nextInt();
            long[] arr= new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }

            long left[]= new long[n];
            left[0]=1;
            for(int i=1;i<n;i++){
                left[i]= (int) (arr[i-1]*left[i-1]);
            }
            long temp=1;


            for(int i=n-1;i>=0;i--){
                left[i]=left[i]*temp;
                temp= temp*arr[i];
            }

           for (long x :left){
               System.out.print(x+" ");
           }
        }
    }
}

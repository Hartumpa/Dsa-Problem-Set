package CodeForces;

import java.util.Scanner;

public class Matrix_Of_Differences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0){
            int n= sc.nextInt();
            int s=1;
            int e=n*n;
            int arr[][]=new int[n][n];
            for (int i=0;i<n;i++){
                if(i%2==0){
                    for (int j=0;j<n;j++){
                        if(j%2==0){
                            arr[i][j]=s++;
                        }else {
                            arr[i][j]=e--;
                        }
                    }
                }
                else {
                    for (int j=n-1;j>=0;j--){
                        if(j%2==0){
                            arr[i][j]=e--;
                        }else {
                            arr[i][j]=s++;
                        }
                    }
                }
            }
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}

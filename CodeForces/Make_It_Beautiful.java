package CodeForces;

import java.util.Arrays;
import java.util.Scanner;

public class Make_It_Beautiful {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0){
            int n= sc.nextInt();
            int arr[]= new int[n];
            for (int i=0;i<n;i++){
                arr[i]= sc.nextInt();
            }
            Arrays.sort(arr);
            int[] newArr = new int[arr.length];
            int frontIndex = 0;
            int backIndex = arr.length-1;

            for(int i=0; i<arr.length; i++) {
                if (i % 2 == 0) {
                    newArr[i] = arr[frontIndex];
                    frontIndex++;
                } else {
                    newArr[i] = arr[backIndex];
                    backIndex--;
                }
            }
            long sum=0;
            int f=0;
            for(int i=0;i<n-1;i++){
                sum+=newArr[i];
                if(sum==newArr[i+1]){
                    f=1;
                    break;
                }
            }
            if(f==0){
                System.out.println("YES");
                for (int i : newArr){
                    System.out.print(i+" ");
                }
                System.out.println();
            }else {
                System.out.println("NO");
            }
        }
    }
}

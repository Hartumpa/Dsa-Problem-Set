package CodeForces;

import java.util.Scanner;

public class Quick_Sort {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0){
            int n= sc.nextInt();
            int k= sc.nextInt();
            int p[]=new int[n];
            for (int i=0;i<n;i++){
                p[i]= sc.nextInt();
            }
            int ans=0;
            int j=1;
            for(int i=0;i<n;i++){
                if(p[i]==j){
                    j++;
                    ans++;
                }
            }
            int res=n-ans;

            if(res%k==0){
                System.out.println(res/k);
            }else {
                System.out.println(res/k+1);
            }

        }
    }
}

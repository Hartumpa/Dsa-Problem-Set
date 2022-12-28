package CodeChef;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k= sc.nextInt();
            String str = sc.next();
            int res=Integer.MAX_VALUE;
            int arr[]= new int[n];
            int c=0;
            for (int i=1;i<n;i++){
                if(str.charAt(i-1)!=str.charAt(i)){
                    c++;
                    arr[i]=c;
                }else {
                    arr[i]=c;
                }
            }
            arr[0]=0;
            for(int i=n-1;i>=0;i--){
                if((i-k+1)<0) break;
                int dekho=arr[i]-arr[i-k+1];
                if(str.charAt(i)=='0') dekho++;
                res=Math.min(res,dekho);
            }
            System.out.println(res);

        }
    }
}

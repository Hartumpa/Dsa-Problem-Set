package Revision;

import java.util.Scanner;

public class Magic_cookies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int req[]= new int[n];

        for(int i=0;i<n;i++){
            req[i]= sc.nextInt();

        }

        int avl[]= new int[n];
        for(int i=0;i<n;i++){
            avl[i]= sc.nextInt();

        }
        int count = 0;
        while(true){
            int val = 0;
            for(int i= 0; i< n; i++){
                if(req[i] <= avl[i])
                    avl[i] -=req[i];
                else{
                    val += req[i] - avl[i];
                    avl[i] = 0;
                }


            }
            if(val > k) break;
            else {
                count++;
                k -=val;
            }
        }
        System.out.print(count);

    }
}

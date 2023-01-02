package Revision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Impress_THe_Boss {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0){
            int n= sc.nextInt();
            int[] arr =new int[n];
            for (int i=0;i<n;i++){
                arr[i]= sc.nextInt();
            }
            Arrays.sort(arr);
            Map<Integer,Integer> map= new HashMap<>();
            for (int x:arr){
                map.put(x,map.getOrDefault(x,0)+1);
            }
            int max=1;
            int flag=0;
            for (Map.Entry<Integer,Integer> x:map.entrySet()){
                if(x.getValue()>1){
                    max=Math.max(max,x.getValue());
                }
                if(x.getValue()==n){
                    flag=1;
                }
            }
            if(flag==1){
                System.out.println(0);
            }else if(max>1){
                System.out.println(n-max+2);
            }else {
                System.out.println(max+1);
            }

        }
    }
}

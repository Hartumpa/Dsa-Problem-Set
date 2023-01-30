package Revision;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Domination {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0){
            int n= sc.nextInt();
            int arr[]= new int[n];
            for (int i=0;i<n;i++){
                arr[i]= sc.nextInt();
            }
            Map<Integer,Integer> map=new HashMap<>();
            for (int i:arr){
                map.put(i,map.getOrDefault(i,0)+1);
            }
            int max=0;

            for (int key : map.keySet()){
                if(map.get(key)>max){
                    max=map.get(key);
                }
            }
            int count=0;
            for (int key : map.keySet()){
                if(map.get(key)==max){
                    count++;
                }
            }
            if(count>1){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}

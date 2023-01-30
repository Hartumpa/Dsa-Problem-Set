package Revision;

import java.util.Scanner;

public class Cows_Bulls {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0){
            int n= sc.nextInt();
            String s1= sc.next();
            String s2=sc.next();
            int count=0;
            int bulls=0;
            for(int i=0;i<n;i++){
                if(s1.charAt(i)==s2.charAt(i)){
                    bulls++;
                }
            }
            for (int i=0;i<n;i++){
                if(s2.contains(String.valueOf(s1.charAt(i)))){
                    count++;
                    s2=s2.replaceFirst(String.valueOf(s1.charAt(i)),"");
                }
            }
            System.out.println(bulls+"A"+(count-bulls)+"B");
        }
    }
}

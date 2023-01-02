package Masai;

import java.io.*;
        import java.util.*;

public class Min_Distance{


    public static void main(String[] args)
            throws IOException {
        Scanner sr= new Scanner(System.in);
        int t= sr.nextInt();
        while(t-- >0){
            int n= sr.nextInt();
            String str= sr.next();
//            char str[]=s.toCharArray();
            List<Integer> list= new ArrayList<>();

            for(int i=0;i<=n;i++){
                if(str.charAt(i)=='1'){
                    list.add(i);
                }
            }
            int len=list.size();
            boolean ev=false;
            boolean od=false;
            for(int i=0;i<len;i++){
                if(list.get(i)%2==0){
                    ev=true;
                }else{
                    od=true;
                }
            }
            if(od==true && ev==true){
                System.out.println(1);
            }else {
                System.out.println(2);
            }
        }
    }






}

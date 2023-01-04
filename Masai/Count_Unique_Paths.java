package Masai;

import java.util.ArrayList;
import java.util.Scanner;

public class Count_Unique_Paths {

    private static ArrayList<String> findPath( int n, int m, int i, int j) {

        if(i==n && j==m){
            ArrayList<String> ans= new ArrayList<>(); // at 3,3 he has no path so it will stand there
            ans.add("");
            return ans;
        }

        ArrayList<String> hpaths= new ArrayList<>();
        ArrayList<String> vpaths= new ArrayList<>();
        if(j<m){
            hpaths=findPath(n,m,i,j+1);
        }

        if(i<n){
            vpaths=findPath(n,m,i+1,j);
        }


        ArrayList<String> res = new ArrayList<>();
        for(String h :hpaths){
            res.add("R"+h);
        }
        for(String v :vpaths){
            res.add("D"+v);
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int mod= (int) (1e9+7);
            ArrayList<String> paths = findPath(n,m,1,1);
            System.out.println(paths);


        }
    }
}

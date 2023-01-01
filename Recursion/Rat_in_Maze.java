package Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rat_in_Maze {

    private static void solve(int i,int j,String ans,int[][] vis,int[][] m,int n,ArrayList<String> res){
        if(i>=n-1 && j>=n-1){
            res.add(ans);
            return;
        }
        //downward
        if(i+1<n && vis[i+1][j]==0 && m[i+1][j]==1 ){
            vis[i][j]=1;
            solve(i+1,j,ans+"D",vis,m,n,res);
            vis[i][j]=0;
        }

        //Left
        if(j-1>=0 && vis[i][j-1]==0 && m[i][j-1]==1 ){
            vis[i][j]=1;
            solve(i,j-1,ans+"L",vis,m,n,res);
            vis[i][j]=0;
        }

        //Right
        if(j+1<n && vis[i][j+1]==0 && m[i][j+1]==1 ){
            vis[i][j]=1;
            solve(i,j+1,ans+"R",vis,m,n,res);
            vis[i][j]=0;
        }

        //Upward
        if(i-1>=0 && vis[i-1][j]==0 && m[i-1][j]==1 ){
            vis[i][j]=1;
            solve(i-1,j,ans+"U",vis,m,n,res);
            vis[i][j]=0;
        }
    }

    private static ArrayList<String> findPath(int[][] m,int n){
        ArrayList<String> res= new ArrayList<>();
        int vis[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        if(m[0][0]==1){
            solve(0,0,"",vis,m,n,res);
        }

        return  res;
    }
    public static void main(String[] args) {
        int n = 4;
        int m[][] = {{1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {1, 1, 0, 0},
                    {0, 1, 1, 1}};
        ArrayList<String> res=findPath(m,n);
        if (res.size() > 0) {
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }
}

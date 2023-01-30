package Revision;

import java.util.Scanner;

public class Walk_In_The_Park {

    public static int countSteps(char[][] arr,int i,int j,int n,int m,boolean visited[][],int count) {
        if(i<0 || j<0 || i>=n || j>=m || visited[i][j]){
            return count;
        }
        visited[i][j] = true;
        switch (arr[i][j]){
            case 'U':
                return countSteps(arr,i-1,j,n,m,visited,count+1);
            case 'R':
                return countSteps(arr,i,j+1,n,m,visited,count+1);
            case 'D':
                return countSteps(arr,i+1,j,n,m,visited,count+1);
            case 'L':
                return countSteps(arr,i,j-1,n,m,visited,count+1);
        }
        return count;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0){
            int n= sc.nextInt();
            int m= sc.nextInt();
            char arr[][]=new char[n][m];
            for (int i=0;i<n;i++){
                arr[i] = sc.next().toCharArray();
            }
            boolean visited[][]=new boolean[n][m];
            System.out.println(countSteps(arr,0,0,n,m,visited,0));
        }
    }
}

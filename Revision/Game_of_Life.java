package Revision;

import java.util.Arrays;
import java.util.Scanner;

public class Game_of_Life {
    static void nextGeneration(int grid[][], int M, int N)
    {
        int[][] future = new int[M][N];


        for (int l = 0; l < M; l++)
        {
            for (int m = 0; m < N; m++)
            {

                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        if ((l+i>=0 && l+i<M) && (m+j>=0 && m+j<N))
                            aliveNeighbours += grid[l + i][m + j];

                aliveNeighbours -= grid[l][m];


                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;


                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;

                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;


                else
                    future[l][m] = grid[l][m];
            }
        }

        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future[i][j] == 0)
                    System.out.print("0");
                else
                    System.out.print("1");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        int arr[][]= new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                arr[i][j]= sc.nextInt();
            }
        }

        nextGeneration(arr, n, m);
    }
}

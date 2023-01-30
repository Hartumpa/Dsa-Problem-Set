package Revision;

import java.util.*;

public class Betty_Buys_A_Present {

    static void Rec(int N, int K, ArrayList<Integer> temp,
                    boolean[] visited, ArrayList<ArrayList<Integer>> result,
                    int last)
    {

        // Base case
        if (N == 0 && K == 0)
        {

            result.add(new ArrayList<>(temp));
            return;
        }

        if (N <= 0 || K <= 0)
            return;

        // Traverse the range [1, 9]
        for(int i = last; i <= 9; i++)
        {

            if (!visited[i])
            {

                // Mark i visitedited
                visited[i] = true;

                // Push i into the vector
                temp.add(i);

                // Recursive call
                Rec(N - 1, K - i, temp, visited,
                        result, i + 1);

                // Pop the last element
                // from temp
                temp.remove(temp.size() - 1);

                // Mark i unvisitedited
                visited[i] = false;
            }
        }
    }

    // Function to check if required
// combination can be obtained or not
    static void combinationSum(int N, int K)
    {

        // If N * 9 is less than K
        if (N * 9 < K)
        {
            System.out.print(-1);
            return;
        }

        // Stores if a number can
        // be used or not
        boolean[] visited = new boolean[10];

        ArrayList<Integer> temp = new ArrayList<>();

        // Stores list of all the
        // possible combinations
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Rec(N, K, temp, visited, result, 1);

        // Print the result[][] array
        if(result.size()==0){
            System.out.println(-1);
            return;
        }
        for(int i = 0; i < result.size(); i++)
        {
            for(Integer x : result.get(i))
                System.out.print(x + " ");

            System.out.println();
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int s= sc.nextInt();
        int k= sc.nextInt();
        combinationSum(k, s);
    }

//    private static void printCombination(int i, int price, int k, int[] arr, ArrayList<Integer> res) {
//        if(k==0){
//            if(price==0){
//                Collections.sort(res);
//                for (int x:res){
//                    System.out.print(x+" ");
//                }
//                System.out.println();
//            }
//            return;
//        }
//        if(i<0 || price<0){
//            return;
//        }
//        res.add(arr[i]);
//        printCombination(i-1,price-arr[i],k-1,arr,res); // choose
//        res.remove(res.size()-1);
//        printCombination(i-1,price,k,arr,res); // not choose
//    }
}

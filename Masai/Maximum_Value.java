package Masai;

import java.util.*;

public class Maximum_Value {

    public static int maxDifference(int[] A) {
        // Create a map to store the indices of each element
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int x = A[i];
            if (!indices.containsKey(x)) {
                indices.put(x, new ArrayList<>());
            }
            indices.get(x).add(i);
        }

        // Find the maximum difference between any two indices for each element
        int maxDiff = 0;
        for (int x : indices.keySet()) {
            List<Integer> indexList = indices.get(x);
            int minIndex = indexList.get(0);
            int maxIndex = indexList.get(0);
            for (int index : indexList) {
                minIndex = Math.min(minIndex, index);
                maxIndex = Math.max(maxIndex, index);
            }
            maxDiff = Math.max(maxDiff, maxIndex - minIndex);
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0){
            int n= sc.nextInt();
            int arr[]= new int[n];
            for (int i=0;i<n;i++){
                arr[i]= sc.nextInt();
            }

            System.out.println(maxDifference(arr));
        }
    }
}

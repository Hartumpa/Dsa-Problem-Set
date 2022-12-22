package Recursion;

public class IsSorted {

    public static boolean solve(int arr[], int i) {
        if (i == arr.length-1) {
            return true;
        }
        return (solve(arr, i + 1) && arr[i] <= arr[i + 1]);
    }

    public static void main(String[] args) {
        int arr[]={1,2,9,4,6,7,7};
        System.out.println(solve(arr,0));
    }

}

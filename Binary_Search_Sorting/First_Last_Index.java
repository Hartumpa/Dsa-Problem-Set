package Binary_Search_Sorting;

import java.util.List;

public class First_Last_Index {
    private static int first(int[] arr, int k) {
        int s = 0, e = arr.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == k) {
                ans = mid;
                e = mid - 1;
            } else if (arr[mid] < k) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    private static int last(int[] arr, int k) {
        int s = 0, e = arr.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == k) {
                ans = mid;
                s = mid + 1;
            } else if (arr[mid] < k) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {5, 7, 8, 8, 8, 8, 10};
        int k = 8;
        System.out.println(first(arr, k)+" "+last(arr, k));
    }
}

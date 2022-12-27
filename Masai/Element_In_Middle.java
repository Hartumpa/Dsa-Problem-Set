package Masai;

import java.util.Arrays;
import java.util.Scanner;

public class Element_In_Middle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = findElement(arr, n);

        System.out.println(ans);
    }

    public static int findElement(int[] arr, int n) {
        int x[] = new int[n];
        Arrays.fill(x, Integer.MIN_VALUE);
        for (int i = 1; i < n; i++) {
            x[i] = Math.max(x[i - 1], arr[i - 1]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > x[i] && min > arr[i]) {
                return arr[i];
            }
            min = Math.min(min, arr[i]);
        }
        return -1;
    }
}

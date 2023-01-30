import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean printCombination(int[] arr, int n, int k, int s, List<Integer> combination) {
        if (k == 0) {
            if (s == 0) {
                System.out.println(combination);
                return true;
            }
            return false;
        }

        if (n == 0 || s < 0) {
            return false;
        }

        boolean found = false;
        combination.add(arr[n - 1]);
        found = printCombination(arr, n - 1, k - 1, s - arr[n - 1], combination);
        combination.remove(combination.size() - 1);
        found = found || printCombination(arr, n - 1, k, s, combination);

        return found;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = arr.length;
        int k = 3;
        int s = 18;

        List<Integer> combination = new ArrayList<>();
        boolean found = printCombination(arr, n, k, s, combination);
        if (!found) {
            System.out.println(-1);
        }
    }
}

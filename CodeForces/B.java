package CodeForces;

import java.util.*;

public class B {
    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> m = new HashMap<>();
        List<List<Integer>> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                list.add(x);
                m.put(x, m.getOrDefault(x, 0) + 1);
            }
            v.add(list);
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int x : v.get(i)) {
                if (m.get(x) < 2) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}

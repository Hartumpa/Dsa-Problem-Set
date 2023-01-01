package CodeForces;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Koxia_and_Whiteboards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            PriorityQueue<Integer> ab = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                ab.add(a);
            }
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                ab.poll();
                ab.add(a);
            }
            long sum = 0;
            while (!ab.isEmpty()) {
                sum += (long) ab.poll();
            }
            System.out.println(sum);
        }
    }
}

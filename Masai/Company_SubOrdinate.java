package Masai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company_SubOrdinate {
    static int MAXN = 202020;

    static List<List<Integer>> adj = new ArrayList<>(MAXN);
    static List<Integer> subtreeSize = new ArrayList<>(MAXN);

    static int calc (int node) {
        if (adj.get(node).size() == 0) {
            return 1;
        } else {
            for (int i = 0; i < adj.get(node).size(); i++) {
                subtreeSize.set(node, subtreeSize.get(node) + calc(adj.get(node).get(i)));
            }
        }
        return subtreeSize.get(node) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < MAXN; i++) {
            adj.add(new ArrayList<>());
            subtreeSize.add(0);
        }
        for (int i = 2; i <= n; i++) {
            int boss = sc.nextInt();
            adj.get(boss).add(i);
        }
        calc(1);
        for (int i = 1; i <= n; i++) {
            System.out.print(subtreeSize.get(i) + " ");
        }
    }
}

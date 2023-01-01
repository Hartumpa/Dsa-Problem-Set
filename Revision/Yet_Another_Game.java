package Revision;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Yet_Another_Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int tc = sc.nextInt();
        while (tc-- > 0) {

            int n = sc.nextInt();

            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i : arr) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            int c = 0;
            for (Map.Entry<Integer, Integer> x : map.entrySet()) {
                if (x.getValue() % 2 == 0) {
                    c++;
                }

            }
            if ((map.size() - c) == 0) {
                System.out.println(2);
            } else
                System.out.println(map.size() - c);


        }


    }
}

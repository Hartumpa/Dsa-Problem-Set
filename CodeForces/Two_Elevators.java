package CodeForces;
//  https://codeforces.com/contest/1729/problem/A

import java.util.Scanner;


public class Two_Elevators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int sum1 = 0;
            int sum2 = 0;
            if (a == 1) {
                System.out.println(1);
            } else if (a != 1) {
                if (b < c) {
                    sum1 = a - 1;
                    sum2 = c - b + c - 1;
                    if (sum1 < sum2) {
                        System.out.println(1);
                    } else if (sum1 == sum2) {
                        System.out.println(3);
                    } else {
                        System.out.println(2);
                    }
                } else if (b > c) {
                    sum2 = b - 1;
                    sum1 = a - 1;
                    if (sum1 < sum2) {
                        System.out.println(1);
                    } else if (sum1 == sum2) {
                        System.out.println(3);
                    } else {
                        System.out.println(2);
                    }
                }
            }
        }
    }
}

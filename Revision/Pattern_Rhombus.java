package Revision;

import java.util.Scanner;


public class Pattern_Rhombus {

    private static void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*" + " ");
            }
            for (int j = n - i - 1; j < 2 * i + 1; j++) {
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    private static void pattern2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < 2 * n - (2 * i + 1); j++) {
                System.out.print("*" + " ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    private static void pattern3(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void pattern4(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                System.out.print(j + " ");
            }
            for (int j = i + 1; j > n; j++) {
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    private static void pattern5(int n) {
        int j, i;
        for (i = 0; i <= n; i++) {
            for (j = n; j > i; j--) {
                System.out.print("  ");
            }
            for (j = 0; j <= i; j++) {
                System.out.print(j + " ");
            }
            for (j = j - 2; j >= 0; j--) {
                System.out.print(j + " ");
            }
            System.out.println();

        }
    }
    private static void pattern6(int n) {
        int j, i;
        for (i = 1; i <= n; i++) {
            for (j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for (j = 0; j <= n-i; j++) {
                System.out.print(j + " ");
            }
            for (j = j - 2; j >= 0; j--) {
                System.out.print(j + " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        pattern3(n);
//        pattern4(n);
        pattern5(n);
        pattern6(n);
    }
}

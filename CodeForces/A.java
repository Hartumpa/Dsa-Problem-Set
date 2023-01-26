package CodeForces;


import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            answer(sc);
            System.out.println();
        }
    }
    public static void answer(Scanner sc) {
        String s = sc.next();
        int n = s.length();
        if (s.charAt(0) == s.charAt(n-1)) {
            System.out.print(s.charAt(0) + " ");
            for (int i = 1; i < n - 1; i++) {
                System.out.print(s.charAt(i));
            }
            System.out.print(" " + s.charAt(n-1));
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = n-1; j > i+1; j--) {
                    String a = s.substring(0, i+1);
                    String b = s.substring(i+1, j);
                    String c = s.substring(j, n);
                    if ((a.compareTo(b) <= 0 && c.compareTo(b) <= 0) || (b.compareTo(a) <= 0 && b.compareTo(c) <= 0)) {
                        System.out.print(a+" " + b + " " + c);
                        return;
                    }
                }
            }
            System.out.print(":(");
        }
    }
}

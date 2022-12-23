package Masai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Kitchen_doors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str = sc.next();

            if (str.indexOf('b') > str.indexOf('B') || str.indexOf('s') > str.indexOf('S') || str.indexOf('g') > str.indexOf('G')) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }


        }
    }


}

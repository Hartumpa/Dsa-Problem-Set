package Masai;

import java.util.Scanner;
import java.util.Stack;

public class PUSH_POP {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        int t = sr.nextInt();
        while (t-- > 0) {
            int n = sr.nextInt();
            int push[] = new int[n];
            int pop[] = new int[n];
            for (int i = 0; i < n; i++) {
                push[i] = sr.nextInt();
            }
            for (int i = 0; i < n; i++) {
                pop[i] = sr.nextInt();
            }
            int j = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                stack.add(push[i]);
                while (!stack.empty() && stack.peek() == pop[j]) {
                    stack.pop();
                    j++;
                }
            }

            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

import java.util.*;

class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                set.add(stack.peek() - nums[i]);
            }

            stack.push(nums[i]);
        }

        while (!stack.isEmpty()) {
            stack.pop();
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                set.add(stack.peek() - nums[i]);
            }

            stack.push(nums[i]);
        }

        sb.append(set.size()).append("\n");
        System.out.print(sb);
    }


}
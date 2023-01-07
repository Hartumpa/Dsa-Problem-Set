package Binary_Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class K_Sum_Path {

    ArrayList<Integer> path = new ArrayList<>();
    int count = 0;

    public void solve(Node root, int k) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        solve(root.left, k);
        solve(root.right, k);
        int n = path.size();
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k) {
                count++;
            }
        }
        path.remove(path.size() - 1); // remove last element added

    }

    public int pathSum(Node root, int targetSum) {
        solve(root, targetSum);
        return count;
    }
}

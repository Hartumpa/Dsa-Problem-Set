import java.util.*;

class Main {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public List<List<Integer>> zigzagTraversal(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            boolean leftToRight = true;
            while (!q.isEmpty()) {
                int level = q.size();
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < level; i++) {
                    TreeNode temp = q.poll();
                    int ind = leftToRight ? i : level - i - 1;
                    ans.add(ind, temp.data);

                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                }
                leftToRight = !leftToRight;
                res.add(ans);
            }
            return res;
        }
    }
}
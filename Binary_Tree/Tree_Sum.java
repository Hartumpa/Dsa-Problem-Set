package Binary_Tree;

///   https://www.codingninjas.com/codestudio/problems/check-if-binary-tree-is-sum-tree-or-not_1164404?leftPanelTab=0
public class Tree_Sum {

    class TreeNode<T> {
        T val;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    ;

    class pair {
        boolean isSum;
        int sum;

        public pair() {

        }

        public pair(boolean isSum, int sum) {
            this.isSum = isSum;
            this.sum = sum;
        }
    }

    public pair check(TreeNode<Integer> root) {
        if (root == null) {
            return new pair(true, 0);
        }
        if (root.left == null && root.right == null) {
            return new pair(true, root.val);
        }

        pair left = check(root.left);
        pair right = check(root.right);

        boolean l = left.isSum;
        boolean r = right.isSum;

        boolean condi = root.val == (left.sum + right.sum);

        pair ans = new pair();

        if (l && r && condi) {
            ans.isSum = true;
            ans.sum = 2 * root.val;
        } else {
            ans.isSum = false;
        }
        return ans;

    }

    public boolean isSumTree(TreeNode<Integer> root) {
        return check(root).isSum;
    }
}



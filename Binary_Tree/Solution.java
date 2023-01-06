package Binary_Tree;

import java.util.*;

public class Solution {

    static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair {
        int x_axis;
        BinaryTreeNode node;

        public Pair(int x_axis, BinaryTreeNode data) {
            this.x_axis = x_axis;
            this.node = data;
        }

        public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            // Map<horizontal_distance , Root.data>
            Map<Integer, Integer> map = new TreeMap<>();
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(0, root));
            while (!q.isEmpty()) {
                Pair temp = q.poll();
                int hd = temp.x_axis;

                BinaryTreeNode frontNode = temp.node;

                if (!map.containsKey(hd)) {
                    map.put(hd, frontNode.val);
                }
                if (temp.node.left != null) {
                    q.add(new Pair(hd - 1, temp.node.left));
                }
                if (temp.node.right != null) {
                    q.add(new Pair(hd + 1, temp.node.right));
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                res.add(entry.getValue());
            }
            return res;
        }
    }
}

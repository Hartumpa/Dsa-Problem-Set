package Binary_Tree;

import java.util.ArrayList;

public class Boundary_Traversal {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static void traverseLeft(TreeNode root,ArrayList<Integer> res){
        if((root==null) || (root.left==null && root.right==null)){
            return;
        }
        res.add(root.data);
        if(root.left!=null){
            traverseLeft(root.left,res);
        }else {
            traverseLeft(root.right,res);
        }
    }

    public static void traverseLeaf(TreeNode root,ArrayList<Integer> res){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            res.add(root.data);
        }
        traverseLeaf(root.left,res);
        traverseLeaf(root.right,res);
    }

    public static void traverseRight(TreeNode root,ArrayList<Integer> res){
        if((root==null) || (root.left==null && root.right==null)){
            return;
        }
        if(root.right!=null){
            traverseRight(root.right,res);
        }else {
            traverseRight(root.left,res);
        }

        // jb wapis aayega tb print
        res.add(root.data);
    }

    public static  ArrayList<Integer> traverseBoundary(TreeNode root){
        ArrayList<Integer> res= new ArrayList<>();
        if(root==null){
            return res;
        }
        res.add(root.data);

        // Left part print
        traverseLeft(root.left,res);

        // Left leaf print subtree
        traverseLeaf(root.left,res);

        // Right leaf print subtree
        traverseLeaf(root.right,res);

        // Right Part print

        traverseRight(root.right,res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root =null;
        ArrayList<Integer> ans =traverseBoundary(root);
    }
}

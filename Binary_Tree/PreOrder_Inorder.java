package Binary_Tree;

import java.util.HashMap;
import java.util.Map;

// isme pre[] wale me start index se start krenge uske baad left node tb right
public class PreOrder_Inorder {

    Map<Integer,Integer> map;

    int index=0;
    private TreeNode solve(int[] preorder, int[] inorder,int start,int end,int n){
        // base
        if(index>=n || start>end){
            return  null;
        }
        int element = preorder[index++];
        int position= map.get(element);

        TreeNode root= new TreeNode();
        root.val=element;
        root.left=solve(preorder,inorder,start,position-1,n);
        root.right=solve(preorder,inorder,position+1,end,n);
        return root;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n=preorder.length;
        map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode ans= solve(preorder,inorder,0,n-1,n);
        return ans;

    }
}

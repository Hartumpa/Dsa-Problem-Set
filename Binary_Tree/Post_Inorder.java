package Binary_Tree;

import java.util.HashMap;
import java.util.Map;


// isme post[] wale me last index se start krenge uske baad right node tb left
public class Post_Inorder {
    Map<Integer,Integer> map;

    int index=-1;
    private TreeNode solve(int[] postorder, int[] inorder,int start,int end,int n){
        // base
        if(index<0 || start>end){
            return  null;
        }
        int element = postorder[index--];
        int position= map.get(element);

        TreeNode root= new TreeNode();
        root.val=element;
        root.right=solve(postorder,inorder,position+1,end,n);
        root.left=solve(postorder,inorder,start,position-1,n);

        return root;
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=postorder.length;
        index=n-1;
        map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode ans= solve(postorder,inorder,0,n-1,n);
        return ans;
    }
}

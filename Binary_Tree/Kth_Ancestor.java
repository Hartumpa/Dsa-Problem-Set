package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Kth_Ancestor {

    int count =-1;
    int res = -1;
    public boolean solve(Node root, int k, int node){
        if(root==null){
            return false;
        }
        if(root.data==node){
            count++;
            if(count==k){
                res=root.data;
            }
            return true;
        }


        boolean leftAns=solve(root.left,k,node);
        boolean rightAns=solve(root.right,k,node);

        if(leftAns){
            count++;
            if(count==k){
                res=root.data;
            }
            return true;
        }

        if(rightAns){
            count++;
            if(count==k){
                res=root.data;
            }
            return true;
        }
        return false;
    }

    public int kthAncestor(Node root, int k, int node)
    {
        solve(root,k,node);
        return res;
    }
    // ----------------------------------------------------------------------------------------------------


    //Method -2
    // check that is it safe to visit this path or not . is safe then pass true //otherwise false.
    boolean isSafe(Node root , int key){
        if(root == null) return false;

        if(root.data == key) return true;

        return isSafe(root.left , key) || isSafe(root.right,key);
    }

    public int kthAncestorMethod2(Node root, int k, int node)
    {
        //Write your code here
        if(root.data == node) return -1;
        ArrayList<Node> arr = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node temp = q.poll();
            if(isSafe(temp , node)){
                arr.add(temp);
            }
            if(temp.left!=null)q.add(temp.left);
            if(temp.right!=null)q.add(temp.right);
        }

        if(arr.isEmpty() || arr.size() == 1) return -1;
        int size = arr.size()-1 -k;
        if(size<0) return -1;
        // System.out.println(size);
        return arr.get(size).data;

    }
}

package Binary_Tree;

public class Lowest_Common_Ancestor {

    public Node lowestCommonAncestor(Node root, Node p, Node q){
        if(root==null){
            return null;
        }
        if(root.data==p.data || root.data==q.data){
            return root;
        }
        Node leftNode=lowestCommonAncestor(root.left, p, q);
        Node rightNode=lowestCommonAncestor(root.right, p, q);

        if(leftNode!=null && rightNode!=null){
            return root;
        }
        if(leftNode!=null && rightNode==null){
            return leftNode;
        }
        if(leftNode==null && rightNode!=null){
            return rightNode;
        }else{
            return null;
        }
    }
}

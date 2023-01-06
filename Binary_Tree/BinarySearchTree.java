package Binary_Tree;

import java.util.*;

public class BinarySearchTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildTree(Node root) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data:");
        int data = sc.nextInt();
        root = new Node(data);
        if (data == -1) {
            return null;
        }
        System.out.println("Enter data for inserting in left of " + data);
        root.left = buildTree(root.left);
        System.out.println("Enter data for inserting in right of " + data);
        root.right = buildTree(root.right);
        return root;
    }

    public static  void buildFromLevelOrder(Node root){
        Scanner sc = new Scanner(System.in);
        Queue<Node> q = new LinkedList<>();
        System.out.println("Enter data for root :");
        int data=sc.nextInt();
        root= new Node(data);
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.peek();
            q.poll();

            System.out.println("Enter data for inserting in left of " + temp.data);
            int leftData= sc.nextInt();
            if(leftData!=-1){
                temp.left=new Node(leftData);
                q.add(temp.left);
            }
            System.out.println("Enter data for inserting in right of " + temp.data);
            int rightData= sc.nextInt();
            if(rightData!=-1){
                temp.right=new Node(rightData);
                q.add(temp.right);
            }
        }
    }

    public static void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);  // root hamesha ek hi level hoga to null usko seperate krega

        while (!q.isEmpty()) {
            Node temp = q.peek();
            q.poll();

            if (temp == null) { // purana level complete ho chuka hai
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

        }
    }

    public static void reverseLevelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.peek();
            stack.add(temp);
            q.poll();

            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }


        }
        while (!stack.isEmpty()) {
            Node res = stack.pop();
            System.out.print(res.data + " ");
        }
    }

    public List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> res= new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        if(root==null){
            return res;
        }
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int level=q.size();
            List<Integer> list= new ArrayList<>();
            for(int i=0;i<level;i++){
                Node temp=q.poll();
                list.add(temp.data);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            stack.add(list);
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottomMethod2(Node root) {
        List<List<Integer>> res= new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        if(root==null){
            return res;
        }
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int level=q.size();
            List<Integer> list= new ArrayList<>();
            for(int i=0;i<level;i++){
                Node temp=q.poll();
                list.add(temp.data);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            res.add(0,list);
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = null;
//        root = buildTree(root);
        // 1 3 7 -1 -1 11 -1 -1 5 12 -1 -1 15  -1 -1
        buildFromLevelOrder(root);
//        levelOrderTraversal(root);
//        System.out.println("Printing Level order Traversal :");
//        levelOrderTraversal(root);
//
//        System.out.println("Printing Reverse Level order Traversal :");
        reverseLevelOrderTraversal(root);


    }
}

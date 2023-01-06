package Binary_Tree;

import java.util.*;

public class Top_View {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class Pair{
        int x_axis;
        Node node;

        public Pair(int x_axis, Node data) {
            this.x_axis = x_axis;
            this.node = data;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        // Map<horizontal_distance , Root.data>
        Map<Integer,Integer> map =new HashMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,root));
        while (!q.isEmpty()){
            Pair temp=q.poll();
            int hd=temp.x_axis;

            Node frontNode =temp.node;

            if(!map.containsKey(hd)){
                map.put(hd,frontNode.data);
            }
            if(temp.node.left!=null){
                q.add(new Pair(hd-1,temp.node.left));
            }
            if(temp.node.right!=null){
                q.add(new Pair(hd+1,temp.node.right));
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}

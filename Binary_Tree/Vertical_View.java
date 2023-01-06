package Binary_Tree;

import java.util.*;

public class Vertical_View {


    //Definition for a binary tree node.



    /*
    Approach:

    Store list of nodes according to the levels
    Nodes first should be stored by separating through vertical level, and then further these vertically separated
    nodes should be separated by rows(as nodes within same row and column should be sorted)

    So to store the nodes according to the above strategy, use HashMap as TreeMap so that the resultant list will be sorted by vertical level
    HashMap -> { verticalLevel, { horizontalLevel, List<Integers> nodes } }

    Understand through the example
    root = [1,2,3,4,6,5,7]

    Now the map will contain data like
    {
        -2 ->  {
                 2 -> [4]
               }
        -1 ->  {
                 1 -> [2]
               }
        0  -> {
                0 -> [1]
                2 -> [6,5]  // This will need to sort when generating resultant list i.e, [5,6]
              }
        1  -> {
                1 -> [3]
              }
        2  -> {
                2 -> [7]
              }
    }

	Then at last extract the resultant list from this map structure and return it
*/

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Tuple{
        TreeNode node;
        int vertical;
        int level;
        Tuple(TreeNode _node,int ver,int lev){
            node = _node;
            vertical = ver;
            level = lev;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map =
                new TreeMap<>();

        //we are using Tree map because we here key is vertical order and we
        //need them in sorted order like -2,-1,0 etc. then the value is again
        //a treemap because in every vertical order we have level and in
        //every level
        //we can have more than one node and we need to keep them sorted so use
        //priority queue for it,in short we have vertical inside it we have
        //levels and in levels we can have many nodes

        Queue<Tuple> q = new LinkedList<Tuple>(); //for level order traversal logic

        q.offer(new Tuple(root,0,0)); //root is at vertical 0 and at level 0

        while(q.size() > 0){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int ver = tuple.vertical;
            int lev = tuple.level;

            if(!map.containsKey(ver)){//if map does not contain this vertical
                map.put(ver,new TreeMap<>());
            }
            //if map does contain the vertical but does not contain the level
            if(!map.get(ver).containsKey(lev)){
                map.get(ver).put(lev,new PriorityQueue<>());
            }

            //if map contains both vertical & level then insert the val in pq
            map.get(ver).get(lev).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left,ver - 1,lev + 1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right,ver + 1,lev + 1));
            }
        }   //end of Level order Traversal

        List<List<Integer>> outer = new ArrayList<>();

        //inside each vertical we have treemap of level(integer) and priorityqueue
        for(TreeMap<Integer,PriorityQueue<Integer>> ys: map.values()){
            outer.add(new ArrayList<>());
            //make a list for each vertical

            for(PriorityQueue<Integer> pq : ys.values()){
                //now we are inside a level(which will contain nodes)
                while(pq.size() > 0){
                    outer.get(outer.size() - 1).add(pq.poll());
                }
            }
        }

        return outer;
    }


}






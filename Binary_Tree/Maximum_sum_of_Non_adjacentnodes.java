package Binary_Tree;

public class Maximum_sum_of_Non_adjacentnodes {

    static class Pair{
        int first; // include value of current node;
        int second; // exclude value of current node;

        public Pair() {
        }

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static Pair solve(Node root){
        if(root== null){
            Pair p = new Pair(0,0);
            return p;
        }
        Pair left =solve(root.left);
        Pair right=solve(root.right);

        Pair ans = new Pair();
        ans.first=root.data+left.second+right.second;
        ans.second=Math.max(left.first,left.second)+Math.max(right.first,right.second);

        return ans;

    }
    static int getMaxSum(Node root)
    {
         Pair res= solve(root);
        return Math.max(res.first,res.second);
    }
}

package Binary_Tree;
//https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
public class Sum_Of_Longest_Path {

    //we retain the value of maxlen and maxsum , so we declare as a static
    static int maxLen = 0;
    static int maxSum= Integer.MIN_VALUE;
    public void solve(Node root,int sum,int len){
        //empty tree
        if(root==null)return;
        //reach at leaf node
        if(root.left==null && root.right==null){
            //sum leaf node data
            sum+=root.data;
            //increase len
            len++;
            //choose the longest path
            if(len>maxLen){
                maxLen = len;
                maxSum = sum;
            }
            //if length of path are same
            else if(len==maxLen){
                //path having maxSum
                if(sum>maxSum)maxSum=sum;
            }
            return;
        }
        sum+=root.data;
        solve(root.left,sum,len+1);
        solve(root.right,sum,len+1);
    }
    public int sumOfLongRootToLeafPath(Node root)
    {
        maxLen = 0;
        maxSum= Integer.MIN_VALUE;
        solve(root,0,0);
        return maxSum;
    }
}

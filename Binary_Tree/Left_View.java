package Binary_Tree;

import java.util.ArrayList;

public class Left_View {

   
    void solve(ArrayList<Integer> ans,Node root, int level ){
        if(root==null){
            return;
        }
        if(level==ans.size()){
            ans.add(root.data);
        }
        solve(ans,root.left,level+1);
        solve(ans,root.right,level+1);  // right view ke liye isko upar kr dena left ke  bss
    }
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans= new ArrayList<>();
        solve(ans,root,0);
        return  ans;
    }
}

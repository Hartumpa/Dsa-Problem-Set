package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Generate_Paraenthesis {

    private static void solve(int n,String str,List<String> res,int i,int j){
        if(str.length()==2*n){
            res.add(str);
            return;
        }
        if(i<n) solve(n,str+"(",res,i+1,j);
        if(j<i) solve(n,str+")",res,i,j+1);
    }

    private static List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        int open=1;
        int close=0;
        solve(n,"(",res,open,close);
        return res;
    }

    public static void main(String[] args) {
        int n=3;
        List<String> res=generateParenthesis(n);
        System.out.println(res);


    }
}

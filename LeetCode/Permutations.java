package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    private static void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }

    private static void solve(int ind,int[] out,Set<List<Integer>> res){
        if(ind>=out.length){
            List<Integer> list = new ArrayList<>();
            for (int n : out) {
                list.add(n);
            }
            res.add(list);
            return;
        }
        for(int i=ind;i<out.length;i++){
            swap(out,ind,i);
            solve(ind+1,out,res);
            swap(out,ind,i);
        }
    }

    public static Set<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> res=new HashSet<>();
        solve(0,nums,res);
        return res;
    }

    public static void main(String[] args) {
        int arr[]={1,1,2};
        Set<List<Integer>> res=permute(arr);
        List<List<Integer>> list= new ArrayList<>();
        for (List<Integer> i:res){
            list.add(i);
        }
        System.out.println(list);
    }
}

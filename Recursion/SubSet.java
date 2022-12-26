package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSet {


    static void mySubset(int index, int[] nums,List<Integer>cur,List<List<Integer>> res) {
        res.add(new ArrayList(cur));

        for(int i=index;i<nums.length;i++){
            cur.add(nums[i]);
            mySubset(i+1,nums,cur,res);
            cur.remove(cur.size()-1);
        }

    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        List<List<Integer>> res = new ArrayList<>();
        mySubset(0, nums, new ArrayList<>(), res);
        System.out.println(res);
    }
}

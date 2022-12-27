package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Letter_Combination_Of_Phone {
    public static void mySubset(String[] key, String digits, StringBuilder val, int ind, List<String> res){
        if(ind>=digits.length()){
            res.add(val.toString());
            return;
        }
        int num=digits.charAt(ind)-'0';
        String out=key[num];
        for(int i=0;i<out.length();i++){
            val.append(out.charAt(i));
            mySubset(key,digits,val,ind+1,res);
            val.deleteCharAt(val.length()-1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] key={"","","abc","def","ghi","jkl","mno","pqrs","uvw","wxyz"};

        mySubset(key,digits, new StringBuilder(""),0 ,res);
        return res;
    }

    public static void main(String[] args) {
        String str="23";
        System.out.println(letterCombinations(str));
    }
}

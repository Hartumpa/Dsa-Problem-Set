package Revision;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class three_sum {

    public static int longestSubstring(String s, int k) {
        if(s.length() <k ){
            return 0;
        }
        int max = 0;
        int[] counts = new int[26];
        for(int i = 0; i < s.length(); i++){
            counts[s.charAt(i)-'a'] += 1;
        }
        boolean[] isValids = new boolean[26];
        boolean allValid = true;
        for(int i = 0; i < 26; i++){
            if(counts[i] > 0 &&counts[i] < k){
                isValids[i] = false;
                allValid = false;
            }else{
                isValids[i] = true;
            }
        }
        if(allValid){
            return s.length();
        }
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            if(isValids[s.charAt(i)-'a'] == false){
                max = Math.max(max, longestSubstring(s.substring(start, i),k));
                start = i + 1;
            }
        }
        max = Math.max(max, longestSubstring(s.substring(start, s.length()),k));
        return max;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        String str= sc.next();
        int k= sc.nextInt();

        System.out.println(longestSubstring(str,k));
    }
}

package Masai;

import java.util.*;

public class MinLength_Substring_Distinct {

    static final int MAX_CHARS = 256;

    // Find maximum distinct characters in any string
    static int max_distinct_char(String str, int n) {
        // Initialize all character's count with 0
        int count[] = new int[MAX_CHARS];
        int max_distinct = 0;
        // Increase the count of max_distinct if a character
        // is found to have a frequency of 1
        for (int i = 0; i < n; i++) {
            count[str.charAt(i)]++;
            if (count[str.charAt(i)] == 1) max_distinct++;
        }
        return max_distinct;
    }

    // A function which accepts a string and returns length
    // of the smallest substring consisting of maximum distinct
    // characters
    static int smallestSubstr_maxDistictChar(String str) {
        int n = str.length();
        // number of unique characters
        int unique = max_distinct_char(str, n);
        // to store the result
        int res = Integer.MAX_VALUE;
        Map<Character, Integer> mp = new HashMap<Character, Integer>();

        int j = 0; // starting index of window
        for (int i = 0; i < str.length(); i++) {
            // add the current chararcter in window
            char c = str.charAt(i);
            if (mp.containsKey(c)) mp.put(c, mp.get(c) + 1);
            else mp.put(c, 1);
            // while no. of distinct elements in the map is
            // equal to unique characters and starting
            // element of the window has frequency more than
            // one we keep reducing its frequency and
            // increasing the starting point of the window

            while (mp.size() == unique && mp.get(str.charAt(j)) > 1) {
                mp.put(str.charAt(j), (mp.get(str.charAt(j)) - 1));
                j++;
            }
            // if size of map is equal to unique elements
            // update the result
            if (mp.size() == unique) res = Math.min(i - j + 1, res);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int len = smallestSubstr_maxDistictChar(str);
        System.out.println(len);


    }
}

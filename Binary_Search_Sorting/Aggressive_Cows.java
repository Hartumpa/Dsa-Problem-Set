package Binary_Search_Sorting;

// Question Link --> https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559?source=youtube&campaign=love_babbar_codestudio2&utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_codestudio2

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Aggressive_Cows {

    private static boolean check(ArrayList<Integer> stalls, int k, int mid) {
        int cowCount = 1;
        int lastPos = stalls.get(0);
        for (int i = 0; i < stalls.size(); i++) {
            if (stalls.get(i) - lastPos >= mid) {
                cowCount++;
                if (cowCount == k) {
                    return true;
                }
                lastPos = stalls.get(i);
            }
        }
        return false;
    }

    public static int aggressiveCows(ArrayList<Integer> stalls, int k) {
        Collections.sort(stalls);
        int s = 0;
        int e = stalls.get(stalls.size() - 1);
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (check(stalls, k, mid)) {
                ans = mid;
                s = mid + 1; // because we want larger Solution
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={4,2,1,3,6};

        ArrayList<Integer> list = new ArrayList<>();
        int k=2;
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        System.out.println(aggressiveCows( list,k));
    }
}

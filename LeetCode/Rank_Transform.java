package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Rank_Transform {
    public static void main(String[] args) {
        int arr[]={40,10,20,30};
        int num[]=arr.clone();
        Arrays.sort(num);
        Map<Integer,Integer> map= new HashMap<>();
        int j=1;
        for(int i=0;i<num.length;i++){
            if(!map.containsKey(num[i])){
                map.put(num[i],j++);
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
    }
}

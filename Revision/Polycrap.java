package Revision;

import java.util.*;

public class Polycrap {
    public static void main(String[] args) {
        int arr[]={1,2,1,7,1,2,1};
        int n=arr.length;
        List<Integer> list= new ArrayList<>();

        Map<Integer,Integer> map= new HashMap<>();


        for (int i=n-1;i>=0;i--){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else {
                break;
            }
        }
        System.out.println(n-map.size());

        PriorityQueue<Integer> pq= new PriorityQueue<>();
        pq.add(2);
        pq.add(6);
        pq.add(3);
        pq.add(1);
        System.out.println(pq);
    }
}

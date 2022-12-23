package Recursion;

import java.util.Arrays;

public class Binary_Search {

    static int binary(int[] arr, int l,int h,int k){
        if(l>h){
            return -1;
        }
        int mid=l+(h-l)/2;
        if(arr[mid]==k){
            return mid;
        }

        if(arr[mid]<k){
           return binary(arr,mid+1,h,k);
        }else{
           return binary(arr,l,mid-1,k);
        }
    }

    public static void main(String[] args) {
        int arr[]={2,4,6,2,14,18};
        int key=2;
        Arrays.sort(arr);
        System.out.println(binary(arr,0,arr.length-1,key));
    }
}

package Recursion;

public class Linear_Search {

    static  boolean linear(int[] arr, int i,int k){
        if(i==arr.length){
            return false;
        }
        if(arr[i]==k){
            return true;
        }else {
            return linear(arr,i+1,k);
        }
    }

    public static void main(String[] args) {
        int arr[]= {3,5,1,2,6};
        int key=0;
        boolean ans=linear(arr,0,key);
        System.out.println(ans);
    }
}

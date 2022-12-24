package Binary_Search_Sorting;

public class Search_In_Rotated_Array {
    public static int getPivot(int arr[], int n){
        int s=0,e=n-1;
        while(s<e){
            int mid=s+(e-s)/2;
            if(arr[mid]>=arr[0]){
                s=mid+1;
            }else{
                e=mid;
            }
        }
        return s;
    }

    public static boolean binary(int[] arr, int l, int h, int k){
        if(l>h){
            return false;
        }
        int mid=l+(h-l)/2;
        if(arr[mid]==k){
            return true;
        }

        if(arr[mid]<k){
            return binary(arr,mid+1,h,k);
        }else{
            return binary(arr,l,mid-1,k);
        }
    }

    public static boolean search(int[] nums, int k) {
        int i=getPivot(nums,nums.length);
        if(k>=nums[i] && k<=nums[nums.length-1]){
            binary(nums,i,nums.length-1,k);
        }else{
            binary(nums,0,i-1,k);
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[]={2,2,2,3,2,2,2};
        int k=3;
        System.out.println(search(arr,k));
    }
}

package Binary_Search_Sorting;

public class Find_Pivot_Point {

    private static int getPivot(int arr[],int n){
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

    public static void main(String[] args) {
        int arr[]={3,8,10,17,1};
        System.out.println(getPivot(arr,arr.length));
    }
}

package Binary_Search_Sorting;

// Question Link ---> https://www.codingninjas.com/codestudio/problems/ayush-gives-ninjatest_1097574?topList=love-babbar-dsa-sheet-problems

public class BooK_Allocation {

    private static boolean isPossible(int[] arr,int n, int c, long mid){
        long count=1;
        long sum=0;
        for(int i=0;i<n;i++){
            if(sum+arr[i]<=mid){
                sum+=arr[i];
            }else{
                count++;
                if(count>c || arr[i]>mid){
                    return false;
                }
                sum=arr[i];
            }
        }
        return true;
    }

    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        long s=0,sum=0;
        for(int i=0;i<m;i++){
            sum+=time[i];
        }
        long e=sum;
        long ans=-1;
        while(s<=e){
            long mid=s+(e-s)/2;
            if(isPossible(time,m,n,mid)){
                ans=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={1,2,2,3,1};
        int days=3;
        System.out.println(ayushGivesNinjatest(days,arr.length,arr));
    }

}

package Dynamic_Programming;

public class target_sum {
    static boolean subsetSumToK(int n, int k,int[] arr){


        boolean prev[]= new boolean[k+1];

        prev[0] = true;

        if(arr[0]<=k)
            prev[arr[0]] = true;

        for(int ind = 1; ind<n; ind++){
            boolean cur[]=new boolean[k+1];
            cur[0] = true;
            for(int target= 1; target<=k; target++){
                boolean notTaken = prev[target];

                boolean taken = false;
                if(arr[ind]<=target)
                    taken = prev[target-arr[ind]];

                cur[target]= notTaken||taken;
            }
            prev=cur;

        }

        return prev[k];
    }

    public static void main(String args[]) {

        int arr[] = {4,3,2,1};
        int k=5;
        int n = arr.length;

        if(subsetSumToK(n,k,arr))
            System.out.println("Subset with given target found");
        else
            System.out.println("Subset with given target not found");
    }
}

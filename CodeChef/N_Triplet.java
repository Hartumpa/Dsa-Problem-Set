package CodeChef;

import java.util.*;

public class N_Triplet {

    private static List<Integer> noSequence(int n,int k,int s){
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<n;i++){
            int x=(s%k+k)%k;
            if(x!=0 && x!=1 && x!=-1){
                res.add(-2);
                return res;
            }
            res.add(x);
            s=(s-x)/k;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int s=sc.nextInt();
            List<Integer> ans= noSequence(n,k,s);

            if(ans.get(0)==-2){
                System.out.println(-2);
            }else{
                for (int x:ans){
                    System.out.print(x+" ");
                }
                System.out.println();
            }
        }
    }
}

package CodeForces;

import java.util.*;

public class Koxia_and_NumberTheory {
    public static boolean isPrime(long n) {
        if(n<=1){
            return false;
        }
        for (long i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0){
            int n= sc.nextInt();
            int arr[]=new int[n];
            for (int i=0;i<n;i++){
                arr[i]= sc.nextInt();
            }
            Map<Long, Long> map= new HashMap<>();
            for (long i=0;i<n;i++){
                map.put((long) arr[(int) i],map.getOrDefault(arr[(int) i], Long.valueOf(0))+1);
            }
            for (Map.Entry<Long,Long> m: map.entrySet()){
                if(m.getValue()>1){
                    System.out.println("NO");
                    return;
                }
            }
            long c=0;
            for (long i=0;i<n;i++){
                if(isPrime(arr[(int) i])){
                    c++;
                }
            }
            if(c%2==0){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }
    }
}

package CodeForces;
import java.util.Scanner;

public class Joey_Takes_Money {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0){
            long n= sc.nextLong();
            long arr[]= new long[(int) n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }
            long x=n-1;
            long res=1;
            for (int i=0;i<n;i++){
                res*=arr[i];
            }
            res=(res+x)*2022;
            System.out.println(res);
        }
    }
}

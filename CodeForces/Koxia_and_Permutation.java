package CodeForces;
import java.util.Scanner;

public class Koxia_and_Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases

        while (t-- >0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int i=1;
            int j=n;
            if(k>1){
                while (i<j){
                    System.out.print((j--)+" "+(i++)+" ");
                }
                if(n%2!=0){
                    System.out.print((n+1)/2);
                }
                System.out.println();
            }else{
                for (int a=1;a<=n;a++){
                    System.out.print(a+" ");
                }
                System.out.println();
            }

        }
    }
}

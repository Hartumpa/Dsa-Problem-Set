import java.util.*;

public class Main{

    public static int elevator(int a,int b,int c){


        int m=(a-1);


        int d=Math.abs(b-c)+Math.abs(c-1);

        if(m>d)
            return 2;
        if(m<d)
            return 1;
        else
            return 3;

    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int t=sc.nextInt();
        while(t-- >0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();

            System.out.println(elevator(a,b,c));
        }
    }
}
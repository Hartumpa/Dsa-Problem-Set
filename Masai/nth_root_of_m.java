package Masai;

import java.util.Scanner;

public class nth_root_of_m {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();
            int x=sc.nextInt();

            findNthRoot(x, n);

//            double result = Math.pow(x, 1.0 / n);
//            System.out.println(Math.floor(result));
//            return (int) Math.floor(result);

//            int res= (int) Math.floor(Math.pow(x,1.0/n));
//            System.out.println(res);
//            double res=solve(n,x);
//            System.out.println(Math.round(res));
        }
    }

    static void findNthRoot(double x, int n)
    {

        // Initialize boundary values
        double low, high;
        if (x >= 0 && x <= 1)
        {
            low = x;
            high = 1;
        }
        else
        {
            low = 1;
            high = x;
        }

        // used for taking approximations
        // of the answer
        double epsilon = 0.00000001;

        // Do binary search
        double guess = (low + high) / 2;
        while (Math.abs((Math.pow(guess, n)) - x)
                >= epsilon)
        {
            if (Math.pow(guess, n) > x)
            {
                high = guess;
            }
            else
            {
                low = guess;
            }
            guess = (low + high) / 2;
        }

        System.out.println(Math.floor(guess));
    }

    public static  double multiply(double a,int n){
        double ans=1.0;
        for (int i=1;i<=n;i++){
            ans*=a;
        }
        return ans;
    }

    public  static  double solve(int n,int x){
        double l=1,h=x;
        double eps=1e-6;
        while((h-l)>eps){
            double mid= l+(h-l)/2.0;
            if(mid*mid==x){
                return mid;
            } else if (multiply(mid,n)<x) {
                l=mid;

            }else{
                h=mid;
            }
        }
        return l;
    }
}

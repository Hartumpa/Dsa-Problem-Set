package Masai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Square_root_sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0){
            int n= sc.nextInt();
            Integer[] arr= new Integer[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }

            Arrays.sort(arr,(a,b)->{
                int root_a= (int) Math.pow(Math.abs(a),0.5);
                int root_b= (int) Math.pow(Math.abs(b),0.5);
                if(root_a>root_b){
                    return 1;
                } else if (root_a<root_b) {
                    return -1;
                }else{
                    return a-b;
                }
            });


            System.out.println(Arrays.toString(arr).replace("[","")
                    .replace(",","").replace("]",""));
        }
    }




    public  static void ram(int n,int [] a){

        List<Integer> sq= new ArrayList<>();
        List<Integer> rt= new ArrayList<>();

        for(int i=0;i<n;i++){
            sq.add(a[i]);
            rt.add((int) Math.sqrt(Math.abs(a[i])));
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(rt.get(i)>rt.get(j)){
                    int temp= rt.get(i);
                    int t2= rt.get(j);
                    rt.set(j,temp);
                    rt.set(i,t2);
                    int s1= sq.get(i);
                    int s2= sq.get(j);
                    sq.set(j,s1);
                    sq.set(i,s2);
                }
                if((rt.get(i)==rt.get(j)) && sq.get(i)>sq.get(j)){

                    int s1= sq.get(i);
                    int s2= sq.get(j);
                    sq.set(j,s1);
                    sq.set(i,s2);
                }
            }
        }
        sq.forEach(x->System.out.print(x+" "));

    }
}

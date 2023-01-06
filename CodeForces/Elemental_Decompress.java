package CodeForces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Elemental_Decompress {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0) {
            int n = sc.nextInt();
            int p=0;
            int anj[]= new int[n+1];
            int har[]=new int[n+1];
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                anj[i+1]=-1;
                har[i+1]=-1;
            }
            int lov1[]= new int[n];
            int lov2[]= new int[n];

            for(int i=0;i<n;i++){
                lov1[i]=0;
                lov2[i]=0;
            }

            TreeSet<Integer> s1 =new TreeSet<>();
            TreeSet<Integer> s2 =new TreeSet<>();
            for (int i=0;i<n;i++){
                if(anj[arr[i]]==-1){
                    anj[arr[i]]=i;
                    lov1[i]=arr[i];
                } else if (har[arr[i]]==-1) {
                    har[arr[i]]=i;
                    lov2[i]=arr[i];
                }else {
                    p=1;
                }
            }
            if(p==1){
                System.out.println("NO");
                continue;
            }
            for (int i=0;i<n;i++){
                if(anj[i+1]==-1){
                    s1.add(i+1);
                }
                if(har[i+1]==-1){
                    s2.add(i+1);
                }
            }
            for (int i=0;i<n;i++){
                if(lov1[i]==0){
                    Integer it = s1.ceiling(lov2[i]);
                    if(it==s1.first()){
                        p=1;
                        break;
                    }else{
                        it--;
                        lov1[i]=it;
                        s1.remove(it);
                    }
                }else {
                    Integer it = s2.ceiling(lov1[i]);
                    if(it==s2.first()){
                        p=1;
                        break;
                    }else{
                        it--;
                        lov2[i]=it;
                        s2.remove(it);
                    }
                }
            }
            if(p==1){
                System.out.println("NO");
                return;
            }
            System.out.println("YES");
            for (int i=0;i<n;i++){
                System.out.print(lov1[i]+" ");
            }
            System.out.println();
            for (int i=0;i<n;i++){
                System.out.print(lov2[i]+" ");
            }
            System.out.println();
        }
    }
}

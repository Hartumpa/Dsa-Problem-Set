package CodeForces;// OM NAMAH SHIVAY
// Stay strong. Be brave. Always belief.

import java.math.BigInteger;
import java.sql.ClientInfoStatus;
import java.util.*;
import java.io.*;
import java.util.Vector;
import static java.lang.Math.sqrt;
import static java.lang.Math.floor;


public class Incinerate {


    static boolean prime[];

    static class Pair implements Comparable<Pair> {
        long x;
        long y;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair o){
            return (int)(this.x-o.x);
        }

    }

    static long power(long x, long y, long p) {
        if (y == 0) return 1;
        if (x == 0) return 0;
        long res = 1l;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1) res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    static void sort(long[] a) {
        ArrayList<Long> l = new ArrayList<>();
        for (long i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readlongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static void sieveOfEratosthenes(int n) {
        prime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) prime[i] = true;
        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= n; i += p) prime[i] = false;
            }
        }
    }

    public static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

    static long binomialCoeff(long n, long r) {
        if (r > n) return 0l;
        long m = 1000000007l;
        long inv[] = new long[(int) r + 1];
        inv[0] = 1;
        if (r + 1 >= 2) inv[1] = 1;
        for (int i = 2; i <= r; i++) {
            inv[i] = m - (m / i) * inv[(int) (m % i)] % m;
        }
        long ans = 1l;
        for (int i = 2; i <= r; i++) {
            ans = (int) (((ans % m) * (inv[i] % m)) % m);
        }
        for (int i = (int) n; i >= (n - r + 1); i--) {
            ans = (int) (((ans % m) * (i % m)) % m);
        }
        return ans;
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static long[] facts=new long[3_000_00];
    //don't care about your feelings

    static long mul(long a, long b) {
        return a*b%mod;
    }

    static long add(long a, long b) {
        return (a+b)%mod;
    }

    /*static void precomp() {
        facts[0]=1;
        for (int i=1; i<facts.length; i++) facts[i]=mul(facts[i-1], i);
    }

    static long exp(long base, long pow) {
        if (pow==0) return 1;
        long half=exp(base, pow/2);
        if (pow%2==0) return mul(half, half);
        return mul(half, mul(half, base));
    }

    static long modInv(long x) {
        return exp(x, mod-2);
    }

    static long nCk(int n, int k) {
        if(n<k) return 0;
        return mul(facts[n], mul(modInv(facts[k]), modInv(facts[n-k])));
    }
*/
    static BigInteger bi(String str) {
        return new BigInteger(str);
    }

    static FastScanner fs = null;
    static long mod = 1_000_000_007;
    static long dp[][][];
    static int ansf[];
    static int ansb[];
    static boolean vis[][][];
    static char ch[][];
    static int xor[];
    static int st,en,n;
    static int d;
    static ArrayList<Pair> al[];
    public static void main(String[] args) {
        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        outer:
        while (t-- > 0) {
            int n = fs.nextInt();
            long k = fs.nextLong();
            long h[] = fs.readlongArray(n);
            long p[] = fs.readlongArray(n);
            PriorityQueue<Pair> al = new PriorityQueue<>();
            for(int i=0;i<n;i++){
                al.add(new Pair(p[i],h[i]));
            }
            //Collections.sort(al);
            long sub=k;
            while(al.size()>0 && k>0){
                Pair r = al.remove();
                if(r.y-sub > 0){
                    k -= r.x;
                    if(k>0) {
                        sub += k;
                    }
                    if(r.y-sub > 0){
                        al.add(new Pair(r.x,r.y));
                    }
                }
            }

            if(al.size()==0){
                out.println("YES");
            }else{
                out.println("NO");
            }

        }
        out.close();
    }
}
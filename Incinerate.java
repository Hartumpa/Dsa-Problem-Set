

import java.io.*;
        import java.util.*;

public class Incinerate {
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
    public static class Pair {
        private int i;
        private  int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args)
            throws IOException
    {
        Reader sr = new Reader();
        int t= sr.nextInt();
        while(t-- >0){
            int n=sr.nextInt();
            int k= sr.nextInt();
            int h[]= new int[n];
            int p[]=new int[n];
            for (int i=0;i<n;i++){
                h[i]= sr.nextInt();
            }
            for (int i=0;i<n;i++){
                p[i]= sr.nextInt();
            }


            System.out.println(ram(n,k,h,p));




        }

    }

    public static String ram(int n,int k,int h[],int p[]){


//        Map<Integer,Integer> map = new HashMap<>();
//
//
//        for(int i=0;i<n;i++){
//            map.put(h[i],p[i]);
//
//        }
        Arrays.sort(h);
        for(int i=0;i<n;i++){
            if(k>=h[i]){
                h[i]=h[i]-k;
            }
        }
//        while(k>0){
//            int min=Integer.MAX_VALUE;
//            Set<Pair> set2 = new HashSet<>();
//
//            for(Pair x : set){
//                if(x.i-k >0){
//                    set2.add(new Pair(x.i-k,x.j));
//                    min=Math.min(min,p[x.j]);
//                }
//            }
//
//            if(set2.size()==0){
//                return "YES";
//            }
//            k-=min;
//            set=set2;
//
//        }
        return "NO";

    }

}
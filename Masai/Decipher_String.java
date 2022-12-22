package Masai;


import java.io.*;
        import java.util.*;

public class Decipher_String {
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

    public static void main(String[] args)
            throws IOException
    {
        Reader sr = new Reader();
        int t= sr.nextInt();
        while(t-- >0){
            int n=sr.nextInt();
            String str= sr.readLine();
            List<Character> list= new ArrayList<>();
            for(int i=0;i<n;i++){
                if(Character.isLetter(str.charAt(i))){
                    int num=0;
                    int j=i+1;
                    while(j<n && Character.isDigit(str.charAt(j))){
                        num=num*10+str.charAt(j)-'0';
                        j++;
                    }
                    for (int k=0;k<num;k++){
                        list.add(str.charAt(i));
                    }
                    i=j-1;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char x :list){
                sb.append(x);
            }
            System.out.println(sb);

//            String str = "aabbcccddd";
//            int[] counts = new int[(int) Character.MAX_VALUE];
//            // If you are certain you will only have ASCII characters, I would use `new int[256]` instead
//
//            for (int i = 0; i < str.length(); i++) {
//                char charAt = str.charAt(i);
//                counts[(int) charAt]++;
//            }
//
//            for (int i = 0; i < counts.length; i++) {
//                if (counts[i] > 0)
//                    //System.out.println("Number of " + (char) i + ": " + counts[i]);
//                    System.out.print(""+ counts[i] + (char) i + "");
//            }
        }


    }
}

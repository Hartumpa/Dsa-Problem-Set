package CodeForces;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Kill_Demodogs {


    public static long solve(long n) {
        // Create a 2D array to store the number of Demodogs at each cell
        long[][] grid = new long[(int) n][(int) n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = (i + 1) * (j + 1);
            }
        }

        // Create a 2D array to store the maximum number of Demodogs that can be killed starting from each cell
        long[][] dp = new long[(int) n][(int) n];
        // Initialize the first cell with the number of Demodogs in it
        dp[0][0] = grid[0][0];
        // Initialize the first row and column with the maximum number of Demodogs that can be killed starting from each cell
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Iterate through the rest of the cells
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                // The maximum number of Demodogs that can be killed starting from the current cell is the maximum of the number of Demodogs that can be killed starting from the cell to the left and the cell above
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[(int) (n - 1)][(int) (n - 1)];
    }

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
            long n=sr.nextLong();
            long ans = solve(n);
            System.out.println((2022L * ans) % (1000000007L));
        }

    }
}

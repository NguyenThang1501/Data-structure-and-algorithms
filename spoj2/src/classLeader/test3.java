package classLeader;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

public class test3 {
    static final class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream dis;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            dis = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextUnsignedInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            return ret;
        }

        public short nextUnsignedShort() throws IOException {
            short ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            do {
                ret = (short) (ret * 10 + c - '0');
            } while ((c = read()) >= '0' && c <= '9');

            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = dis.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (dis == null)
                return;
            dis.close();
        }
    }

    static short[][] data = new short[1001][1001];

    public static short solve(int n, int k) {
        if (n == 1) return 1;
        else {
            data[n][k] = (short) ((solve( (n - 1), k) + k - 1) % n + 1);
            return data[n][k];
        }
    }

    public static void pre() {
        for (int i = 1; i <= 1000; i++) {
            data[1][i] = 1;
            solve(1000, i);
        }
    }

    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        int t = r.nextUnsignedInt();
        short n,m,o;
        pre();
        for (int j =0; j<t;j++){
            n = r.nextUnsignedShort();
            m = r.nextUnsignedShort();
            o = r.nextUnsignedShort();
            System.out.println((m + data[n][o] - 1) % (n) + 1);
        }
    }
}

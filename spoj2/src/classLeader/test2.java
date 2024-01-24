package classLeader;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class test2 {
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

    public static void main(String args[]) throws IOException {

        Reader r = new Reader();

        int t = r.nextUnsignedInt();
        int n, m, o;

        ArrayList<Short> list = new ArrayList<>();
        ArrayList<Short> listTemp = new ArrayList<>();

        for (short j = 1; j <= 1000; j++) {
            list.add(j);
            listTemp.add(j);
        }

        while (t-- > 0) {
            n = r.nextUnsignedShort();
            m = r.nextUnsignedShort();
            o = r.nextUnsignedShort();


            if ((0 < n && n <= 1000) && (0 < m && m <= n) && (0 < o && o <= n)) {
                int index = (m + o - 1) % n;
                while (n > 1) {
                    listTemp.remove(index);
                    n--;
                    index = (index + o - 1) % n;
                }
                System.out.println(listTemp.get(index));
                listTemp = (ArrayList<Short>) list.clone();
            }

        }
        r.close();

    }

}

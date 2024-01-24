package easyQueue;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Main {
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
            int count = 0;
            if (c == '-') count++;
            while (c <= ' ' || c == '-')
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (count != 0) return -ret;
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
        StringBuilder sb = new StringBuilder();
        Queue<Long> queue = new LinkedList<>();
        int no_of_operations = r.nextUnsignedInt();
        int t;
        long n;

        while (no_of_operations-- > 0) {
            t = r.nextUnsignedInt();
            if (t == 1) {
                n = r.nextUnsignedInt();
                System.out.println("nnn" + n);
                queue.add(n);
            } else if (t == 2) {
                if (!queue.isEmpty()) {
                    queue.poll();
                }
            } else {
                if (queue.isEmpty()) {
                    sb.append("Empty!\n");
                } else {
                    sb.append(queue.peek());
                    sb.append('\n');
                }
            }
        }
        System.out.print(sb);
    }
}
package arrangingAmplifiers;

import java.lang.StringBuilder;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

class test5 {
    static final class Reader{
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream dis;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader(){
            dis = new DataInputStream(System.in); // Đọc dữ liệu nhập vào
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextUnsignedInt() throws IOException{
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            do{
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            return ret;
        }

        private void fillBuffer() throws IOException{
            bytesRead = dis.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException{
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException{
            if (dis == null)
                return;
            dis.close();
        }
    }

    public static void main(String args[]) throws IOException{
        Reader r = new Reader();

        int no_of_operations = r.nextUnsignedInt();
        int n;

        while (no_of_operations-- > 0) {
            StringBuilder sb = new StringBuilder();
            n = r.nextUnsignedInt();
            int[] arr = new int[n];
            int count = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = r.nextUnsignedInt();
                if (arr[j] == 1) count++;
            }

            Arrays.sort(arr);
            for (int k = 0; k < count; k++) {
                sb.append("1 ");
            }
            if (n - count == 2 && arr[n - 2] == 2 && arr[n - 1] == 3) {
                sb.append("2 3");
            } else {
                for (int m = arr.length - 1; m >= count; m--) {
                    sb.append(arr[m] + " ");
                }
            }
            System.out.println(sb);
        }
    }
}

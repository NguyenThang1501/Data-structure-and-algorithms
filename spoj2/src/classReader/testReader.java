package classReader;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Stack;

public class testReader {
    static final class Reader{
        final private int BUFFER_SIZE = 1 ;
        private DataInputStream dis;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader(){
            dis = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextUnsignedInt() throws IOException {
            int ret = 0;
            System.out.println("ret" + ret);
            byte c = read(); // c có giá trị theo bảng mã acci
            System.out.println("c"+c);
            while (c <= ' ')
                c = read();
            do{
                ret = ret * 10 + c - '0'; // -'0' để trả về gtri nguyen cua c (c=49 --> c-'0' = 1)
                System.out.println("ret while"+ret);
            }  while ((c = read()) >= '0' && c <= '9');

            return ret;
        }

        private void fillBuffer() throws IOException{
            bytesRead = dis.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            System.out.println("byy" + bytesRead);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException{
            System.out.println("buff" + bufferPointer);
            System.out.println("byte" + bytesRead);
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

    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int no_of_operations = r.nextUnsignedInt();
        System.out.println("noo" + no_of_operations);
    }
}

package classLeader;

import java.io.*;
import java.util.*;

public class test6 {
    static int[] data = new int[1001000];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        pre();
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            sb.append((j + data[(n - 1) * 1000 + k] - 1) % n + 1).append('\n');
        }
        System.out.print(sb);
    }

    static void pre() {
        for (int i = 1; i <= 1000; i++) {
            data[i] = 1;
            solve(1000, i);
        }
    }

    static int solve(int n, int k) {
        if (n == 1) return 1;
        else {
            data[(n - 1) * 1000 + k] = (solve(n - 1, k) + k - 1) % n + 1;
            return data[(n - 1) * 1000 + k];
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        String next() {
            while (!st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

package classLeader;


import java.util.Scanner;

public class test1 {
    static int[][] data = new int[1001][1001];

    public static int solve(int n, int k) {
        if (n == 1) return 1;
        else {
            data[n][k] = (solve(n - 1, k) + k - 1) % n + 1;
            return data[n][k];
        }
    }

    public static void pre() {
        for (int i = 1; i <= 1000; i++) {
            data[1][i] = 1;
            solve(1000, i);
        }
    }

    public static void main(String[] args) {
        pre();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            short n = sc.nextShort();
            short m = sc.nextShort();
            short o = sc.nextShort();
            System.out.println((m + data[n][o] - 1) % (n) + 1);
        }
    }
}

import java.util.Scanner;

public class SNTGT {
    public static boolean checkFactorial(int n) {
        int s = 1;
        for (int i = 1; i <= n; i++) {
            s *= i;
            if (n == s) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (checkFactorial(a[i] - 1) || checkFactorial(a[i] + 1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

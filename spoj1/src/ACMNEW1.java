import java.util.Arrays;
import java.util.Scanner;

public class ACMNEW1 {
    public static int result(int[] arr, int n) {
        int[] sum = new int[n * (n - 1) * (n - 2) / 6];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    sum[count] = arr[i] + arr[j] + arr[k];
                    count++;
                }
            }
        }

        Arrays.sort(sum);
        for (int i = sum.length - 1; i > 0; i--) {
            if (sum[i] <= n) {
                return sum[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int[] a = new int[l];
            for (int j = 0; j < l; j++) {
                a[j] = sc.nextInt();
            }
            int max = sc.nextInt();
            System.out.println(result(a, max));
        }
    }
}

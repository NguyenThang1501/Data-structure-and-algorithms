import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SNTIFIBO {
    public static boolean checkFibonacci(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(1);
        int count = 1;
        while (arr.get(count) < n) {
            count++;
            arr.add(arr.get(count - 1) + arr.get(count - 2));
        }
        if (arr.get(count) == n) {
            return true;
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
            if (checkFibonacci(a[i])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

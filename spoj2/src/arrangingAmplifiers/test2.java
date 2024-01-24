package arrangingAmplifiers;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte t = sc.nextByte();
        int[] arr = new int[100000];
        int n;
        while (t>0){
            n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr, 0, n - 1);
            int count = 0;
            while (arr[count] == 1) {
                System.out.print("1 ");
                count++;
            }
            if (n - count == 2 && arr[count] == 2 && arr[count + 1] == 3) {
                System.out.print("2 3");
            } else {
                for (int m = n - 1; m >= count; m--) {
                    System.out.print(arr[m] + " ");
                }
            }
            System.out.println();
            t--;
        }

    }
}

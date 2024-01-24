package arrangingAmplifiers;

import java.util.Arrays;
import java.util.Scanner;

public class ARRANGE {
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte t = sc.nextByte();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            int count = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextLong();
                if (arr[j] == 1) count++;
            }

            Arrays.sort(arr);
            for (int k = 0; k < count; k++) {
                System.out.print("1 ");
            }
            if (n - count == 2 && arr[n - 2] == 2 && arr[n - 1] == 3) {
                System.out.print("2 3");
            } else {
                for (int m = arr.length-1; m >=count; m--) {
                    System.out.print(arr[m]+" ");
                }
            }
            System.out.println();
        }

    }
}

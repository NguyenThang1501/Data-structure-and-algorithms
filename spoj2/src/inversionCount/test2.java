package inversionCount;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    public static long mergeAndCount(long[] arr, int l, int m, int r) {

        long[] left = Arrays.copyOfRange(arr, l, m + 1);
        long[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;
        long swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swaps;
    }

    // Merge sort function
    public static long mergeSortAndCount(long[] arr, int l, int r) {
        long count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m + 1, r);
            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();
       // long[] result = new long[t];
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long[] array = new long[n];
            for (int j = 0; j < n; j++) {
                array[j] = sc.nextLong();
            }
            System.out.println(mergeSortAndCount(array, 0, array.length - 1));
        }
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
    }
}

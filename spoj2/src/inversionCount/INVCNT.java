package inversionCount;

import java.util.Arrays;
import java.util.Scanner;

public class INVCNT {

    public static int minIndexArray(int[] array) {
        int min = array[0];
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int[] removeIndex(int[] array, int index) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        return Arrays.copyOf(array, array.length - 1);
    }

    public static int inversionCount(int[] array, int n) {
        int minIndex = minIndexArray(array);
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            count += minIndex;
            array = removeIndex(array, minIndex);
            minIndex = minIndexArray(array);
        }
        return count;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = sc.nextInt();
            }
            System.out.println(inversionCount(array,n));
        }
    }
}

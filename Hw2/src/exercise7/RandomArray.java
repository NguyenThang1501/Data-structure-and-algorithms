package exercise7;

import java.util.Random;

public class RandomArray {
    public static int[] createArray(int N, int M) {
        int[] array = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(M) + 1;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    i--;
                    break;
                }
            }

        }
        return array;
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(createArray(10, 200));
    }
}

package THBuoi2;

import java.util.Random;

public class Sort {
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static int[] inputArray(int n) {
        int[] a = new int[n];
        Random random = new Random();
        a[0] = random.nextInt(200);
        for (int i = 1; i < n; i++) {
            while (a[i] < a[i - 1]) {
                a[i] = random.nextInt(200);
            }
        }
        return a;
    }

    public static void bubbleSort(int[] a) {
        int countDoiCho = 0;
        int countSoSanh = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {
                countSoSanh++;
                if (a[j - 1] > a[j]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    countDoiCho++;
                }
            }
            System.out.print("Lan thu " + i + ": ");
            printArray(a);
        }
        System.out.println("So lan doi cho: " + countDoiCho);
        //Do phuc tap O(n^2)
        System.out.println("SO lan so sanh: " + countSoSanh);
    }

    public static void selectionSort(int[] a) {
        int countDoiCho = 0;
        int countSoSanh = 0;
        for (int i = a.length - 1; i >= 1; i--) {
            int maxIdx = i;
            for (int j = 0; j < i; j++) {
                countSoSanh++;
                if (a[j] >= a[maxIdx]) {
                    maxIdx = j;
                }
            }
            int temp = a[maxIdx];
            a[maxIdx] = a[i];
            a[i] = temp;
            countDoiCho++;

            System.out.print("Lan thu " + (a.length - i) + ": ");
            printArray(a);
        }
        System.out.println("So lan doi cho: " + countDoiCho);
        System.out.println("SO lan so sanh: " + countSoSanh);
    }

    public static void insertionSort(int[] a) {
        int countDoiCho = 0;
        int countSoSanh = 0;
        for (int i = 1; i < a.length; i++) {
            int next = a[i];
            int j;
            countSoSanh++;
            for (j = i - 1; j >= 0 && a[j] > next; j--) {
                a[j + 1] = a[j];
                countDoiCho++;
            }
            a[j + 1] = next;

            System.out.print("Lan thu " + i + ": ");
            printArray(a);
        }
        System.out.println("So lan doi cho: " + countDoiCho);
        System.out.println("SO lan so sanh: " + countSoSanh);

    }

    public static void main(String[] args) {
//        int[] a = {2, 1, 8};
//        final long startTime = System.currentTimeMillis();
//        bubbleSort(a);
//        final long endTime = System.currentTimeMillis();
//        System.out.println("Total execution time: " + (endTime - startTime) + " millisecond");
        int[] randomArray = inputArray(10);
        printArray(randomArray);
        final long startTime = System.nanoTime();
        bubbleSort(randomArray);
        printArray(randomArray);
        final long endTime = System.nanoTime();
        System.out.println("Total execution time: " + (endTime - startTime) + " nanosecond");
//        insertionSort(randomArray);
//        printArray(randomArray);
    }
}

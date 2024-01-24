package exercise5;

public class SelectionSort {
    public static <T> void printArray(T[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");

        }
        System.out.println();
    }

    public static <T extends Comparable<T>> T[] sort(T[] a) {
        int count = 0;
        for (int i = a.length - 1; i >= 1; i--) {
            int maxIdx = i;
            for (int j = 0; j < i; j++) {
                if (a[j].compareTo(a[maxIdx]) >= 0) {
                    maxIdx = j;
                }
            }
            T temp = a[maxIdx];
            a[maxIdx] = a[i];
            a[i] = temp;
            count++;

            System.out.print("Lan thu " + (a.length - i) + ": ");
            printArray(a);
        }
        System.out.println("So lan doi cho: " + count);
        return a;
    }

    public static void main(String[] args) {
        String[] a = {"B", "A", "D", "C"};
        printArray(sort(a));

        Integer[] b = {5, 7, 3, 9, 1, 2};
        printArray(sort(b));
    }
}

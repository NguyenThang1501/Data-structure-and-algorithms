package exercise5;

public class InsertionSort {
    public static <T> void printArray(T[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");

        }
        System.out.println();
    }

    public static <T extends Comparable<T>> T[] sort(T[] a) {
        int count = 0;
        for (int i = 1; i < a.length; i++) {
            T next = a[i];
            int j;

            for (j = i - 1; j >= 0 && a[j].compareTo(next) > 0; j--) {
                a[j + 1] = a[j];
                count++;
            }
            a[j + 1] = next;

            System.out.print("Lan thu " + i + ": ");
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

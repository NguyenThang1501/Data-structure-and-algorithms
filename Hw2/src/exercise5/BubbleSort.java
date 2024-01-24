package exercise5;

public class BubbleSort<T> {
    public static <T> void printArray(T[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");

        }
        System.out.println();
    }

    public static <T extends Comparable<T>> T[] sort(T[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (a[j - 1].compareTo(a[j]) > 0) {
                    T temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    count++;
                }
            }
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

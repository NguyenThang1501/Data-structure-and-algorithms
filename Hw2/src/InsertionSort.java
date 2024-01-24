public class InsertionSort {

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
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
        System.out.println("So lan so sanh: " + countSoSanh);
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 8, 6, 9, 5, 2};
        insertionSort(a);
    }
}

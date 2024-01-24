public class SelectionSort {

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
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
        System.out.println("So lan so sanh: " + countSoSanh);
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 8, 6, 9, 5, 2};
        selectionSort(a);
    }
}

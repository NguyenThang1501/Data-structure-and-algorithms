public class BubbleSort {
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
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
        System.out.println("So lan so sanh: " + countSoSanh);
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 8, 6, 9, 5, 2};
        bubbleSort(a);
    }
}

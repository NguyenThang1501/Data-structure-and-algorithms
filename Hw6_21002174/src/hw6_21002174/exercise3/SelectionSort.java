package hw6_21002174.exercise3;

public class SelectionSort {

    public void selectionSort(int[] a) {
        for (int i = a.length - 1; i >= 1; i--) {
            int maxIdx = i;
            for (int j = 0; j < i; j++) {
                if (a[j] >= a[maxIdx]) {
                    maxIdx = j;
                }
            }
            int temp = a[maxIdx];
            a[maxIdx] = a[i];
            a[i] = temp;
        }
    }
}

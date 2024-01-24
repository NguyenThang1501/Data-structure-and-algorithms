package selection;

public class SelectionSort {
    public static void selectionSort(int[] a){
        int n = a.length;
        for (int i=0; i<n; i++){
            int minIndex = i;
            for (int j =i+1; j<n;j++){
                if (a[j] <a[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex !=i){
                int t=a[i];
                a[i] = a[minIndex];
                a[minIndex] = t;
            }
        }
    }
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 2, 7, 8, 1, 2};
        selectionSort(a);
        printArray(a);
    }

}

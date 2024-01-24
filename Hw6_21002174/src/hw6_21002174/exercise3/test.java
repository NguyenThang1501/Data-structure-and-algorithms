package hw6_21002174.exercise3;

import java.util.Arrays;
import java.util.Random;

public class test {
    public static int[] createArr(int n){
        int[] array = new int[n];
        for (int i = 0; i<n; i++){
            Random random = new Random();
            array[i] = random.nextInt(n*10)+1;
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
        int n = 10000;
        int[] arr = createArr(n);
        int[] arr1 = Arrays.copyOf(arr,n);
        int[] arr2 = Arrays.copyOf(arr,n);
        int[] arr3 = Arrays.copyOf(arr,n);
        int[] arr4 = Arrays.copyOf(arr,n);
        System.out.println("Original array: ");
        printArray(arr);

        System.out.println();
        System.out.println("Using heap sort");
        HeapSort heapSort = new HeapSort();
        final long startTime = System.nanoTime();
        heapSort.sort(arr1);
        //printArray(arr1);
        final long endTime = System.nanoTime();
        System.out.println("Total execution time: " + (endTime - startTime));

        System.out.println();
        System.out.println("Using merge sort");
        MergeSort mergeSort = new MergeSort();
        final long startTime1 = System.nanoTime();
        mergeSort.sort(arr2,0,n-1);
        //printArray(arr2);
        final long endTime1 = System.nanoTime();
        System.out.println("Total execution time: " + (endTime1 - startTime1));

        System.out.println();
        System.out.println("Using quick sort");
        QuickSort quickSort = new QuickSort();
        final long startTime2 = System.nanoTime();
        quickSort.sort(arr3,0,n-1);
        //printArray(arr3);
        final long endTime2 = System.nanoTime();
        System.out.println("Total execution time: " + (endTime2 - startTime2));

        System.out.println();
        System.out.println("Using selection sort");
        SelectionSort selectionSort = new SelectionSort();
        final long startTime3 = System.nanoTime();
        selectionSort.selectionSort(arr4);
        //printArray(arr4);
        final long endTime3 = System.nanoTime();
        System.out.println("Total execution time: " + (endTime3 - startTime3));

    }
}

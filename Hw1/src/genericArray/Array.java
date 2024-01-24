package genericArray;

import java.util.Scanner;

public class Array {
    public static int[] inputArray(Scanner sc, int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean search(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public static int[] sortArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng: ");
        int n = scan.nextInt();
        System.out.println("Nhập giá trị các phần tử:");
        int[] array = inputArray(scan, n);

        System.out.println("Mảng vừa nhập là:");
        printArray(array);

        System.out.println("Nhập phần tử cần tìm trong mảng");
        int value = scan.nextInt();
        if (search(value, array)) {
            System.out.println(value + " có nằm trong mảng ");
        } else {
            System.out.println(value + " không có trong mảng");
        }

        System.out.println("Mảng sau khi sắp xếp tăng dần là: ");
        printArray(sortArray(array));

//        System.out.println("Test các hàm dùng generic");
//        Integer[] a = new Integer[2];
//        a[0] = 1;
//        a[1] = 2;
//        printArrayGeneric(a);
//        System.out.println(search(a, 2));
//
//        String[] b = new String[2];
//        b[0] = "12";
//        b[1] = "aaa";
//        printArrayGeneric(b);
//        System.out.println(search(b, "  "));
    }
}

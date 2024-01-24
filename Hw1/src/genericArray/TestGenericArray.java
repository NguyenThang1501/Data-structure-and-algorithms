package genericArray;

import java.util.Scanner;

public class TestGenericArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        GenericArray genericArray = new GenericArray<Integer>(n);
        for (int i = 0; i < n; i++) {
            genericArray.setElement(i, i);
        }
        System.out.println("Array: ");
        genericArray.printArrayGeneric();
        System.out.println(genericArray.search(2));
    }
}

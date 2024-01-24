package Hw3_21002174.complex;

import java.util.Scanner;

public class Test {
    public static Complex[] inputComplex(int n) {
        Complex[] complexArray = new Complex[n];
        for (int i = 0; i < n; i++) {
            float real = (float) Math.random() * 100;
            float image = (float) Math.random() * 100;
            complexArray[i] = new Complex(real, image);
        }
        return complexArray;
    }

    public static void printComplexArray(Complex[] complexArray) {
        for (int i = 0; i < complexArray.length; i++) {
            System.out.println(complexArray[i].toString());
        }
    }

    public static void printComplexV(Complex[] complexArray, int v) {
        if (v >= complexArray.length || v < 0) {
            System.out.println("Khong ton tai so phuc o vi tri " + v);
        } else {
            System.out.println(complexArray[v].toString());
        }
    }

    public static Complex addMany(int n) {
        Complex[] complexArray = inputComplex(n);
        Complex sum = new Complex(0, 0);
        System.out.println("Day cac so phuc:");
        printComplexArray(complexArray);
        for (int i = 0; i < n; i++) {
            sum = sum.add(complexArray[i]);
        }
        System.out.println("Tong la:");
        return sum;
    }

    public static Complex timeMany(int n) {
        Complex[] complexArray = inputComplex(n);
        Complex multi = new Complex(1, 1);
        System.out.println("Day cac so phuc:");
        printComplexArray(complexArray);
        for (int i = 0; i < n; i++) {
            multi = multi.time(complexArray[i]);
        }
        System.out.println("Tich la:");
        return multi;
    }

    public static void main(String[] args) {
        System.out.println("Nhap n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Complex[] complexArray = inputComplex(n);
        printComplexArray(complexArray);

        System.out.println("Nhap v");
        int v = sc.nextInt();
        printComplexV(complexArray, v);

        System.out.println("So cac so phuc can tinh tong:");
        int a = sc.nextInt();

        System.out.println(addMany(a));
        System.out.println(timeMany(a));
    }
}

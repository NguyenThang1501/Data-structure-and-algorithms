package arrangingAmplifiers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class test3 {
    static void swap(ArrayList<Integer> a, int i, int j) {
        int x = a.get(i);
        a.set(i, a.get(j));
        a.set(j, x);
    }

    static void reverse(ArrayList<Integer> a, int x) {
        int n = a.size();
        n--;
        while (x < n) {
            swap(a, x, n);
            x++;
            n--;
        }

    }

    public static ArrayList<Integer> arrangeGame(ArrayList<Integer> arr) {
        int n = arr.size();

        Collections.sort(arr);
        // To count the number of 1 in the array
        int countOne = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 1) {
                countOne++;
            }
        }

        // Handling the cornor case
        if (countOne + 2 == n && arr.get(n - 1) == 3 && arr.get(n - 2) == 2) {
            return arr;
        }

        reverse(arr, countOne);

        return arr;

    }

    public static void printArray(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n;
        while (t > 0) {
            n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }
            printArray(arrangeGame(arr));
            t--;
        }
    }
}
package arrangingAmplifiers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            ArrayList<Long> arr = new ArrayList<>();
            int count = 0;
            for (int j = 0; j < n; j++) {
                long temp = sc.nextLong();
                if (temp == 1) {
                    count++;
                } else {
                    arr.add(temp);
                }
            }
            Collections.sort(arr);
            for (int k = 0; k < count; k++) {
                System.out.print("1 ");
            }
            if (arr.size() == 2 && arr.get(0) == 2 && arr.get(1) == 3) {
                System.out.print("2 3");
            } else {
                for (int m = arr.size() - 1; m >=0; m--) {
                    System.out.print(arr.get(m) + " ");
                }
            }
            System.out.println();
        }

    }
}

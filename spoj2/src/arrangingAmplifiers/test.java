package arrangingAmplifiers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int count = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < n; j++) {
                int temp = sc.nextInt();
                if (temp == 1) {
                    count++;
                } else {
                    pq.add(temp);
                }
            }
            StringBuilder result = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            for (int k = 0; k < count; k++) {
                result.append(1 + " ");
                temp.append(1 + " ");
            }
            temp.append(3 + " " + 2);
            for (int m = 0; m < n - count; m++) {
                result.append(pq.poll() + " ");
            }
            if (result.equals(temp)) {
                temp.delete(count, n - 1);
                temp.append(2 + " " + 3);
                System.out.println(temp);
            } else {
                System.out.println(result);
            }


//            int[] arr = new int[n];
//            int count = 0;
//            for (int j = 0; j < n; j++) {
//                arr[j] = sc.nextInt();
//                if (arr[j] == 1) count++;
//            }
//            Arrays.sort(arr);
//            for (int k = 0; k < count; k++) {
//                System.out.print("1 ");
//            }
//            if (n - count == 2 && arr[n - 2] == 2 && arr[n - 1] == 3) {
//                System.out.print("2 3");
//            } else {
//                for (int m = arr.length-1; m >=count; m--) {
//                    System.out.print(arr[m]+" ");
//                }
//            }
//            System.out.println();
        }

    }
}

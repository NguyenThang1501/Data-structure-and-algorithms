package arrangingAmplifiers;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte t = sc.nextByte();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int count = 0;
            PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < n; j++) {
                long temp = sc.nextLong();
                if (temp == 1) {
                    count++;
                } else {
                    pq.add(temp);
                }
            }
            for (int j = 0; j < count; j++) {
                System.out.print("1 ");
            }
            if (n - count == 2 && pq.poll() == 3 && pq.poll() == 2) {
                System.out.print("2 3");
            } else {
                for (int j = count; j < n; j++) {
                    System.out.print(pq.poll() + " ");
                }
            }
            System.out.println();
        }
    }
}

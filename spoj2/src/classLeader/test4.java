package classLeader;

import java.util.ArrayList;
import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Short> list = new ArrayList<>();
        ArrayList<Short> listTemp = new ArrayList<>();
        int t = sc.nextInt();
        for (short j = 1; j <= 1000; j++) {
            list.add(j);
            listTemp.add(j);
        }

        for (int i = 0; i < t; i++) {
            short n = sc.nextShort();
            short m = sc.nextShort();
            short o = sc.nextShort();
            if ((0 < n && n <= 1000) && (0 < m && m <= n) && (0 < o && o <= n)) {
                int index = (m + o - 1) % n;

                while (n > 1) {
                    listTemp.remove(index);
                    n--;
                    index = (index + o - 1) % n;
                }
                System.out.println(listTemp.get(index));
                listTemp = (ArrayList<Short>) list.clone();
            }
        }

    }
}

package classLeader;

import java.util.ArrayList;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Short> list = new ArrayList<>();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            short n = sc.nextShort();
            short m = sc.nextShort();
            short o = sc.nextShort();

            for (short j = 1; j <= n; j++) {
                list.add(j);
            }

            int index = (m + o - 1) % n;
            while (list.size() > 1) {
                list.remove(index);
                n--;
                index = (index + o - 1) % n;
            }
            for (short temp : list) {
                System.out.println(temp);
            }
            list.clear();
        }

    }
}

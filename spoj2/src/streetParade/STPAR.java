package streetParade;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class STPAR {
    public static boolean check(ArrayList<Integer> array) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) > array.get(i + 1)) {
                if (!stack.isEmpty()) {
                    if (array.get(i) > stack.peek()) {
                        return false;
                    }
                }
                stack.push(array.get(i));
                array.remove(i);
                i--;

            }
            if (!stack.isEmpty()  && array.get(i) - stack.peek() == 1) {
                array.add(stack.pop());
                i++;
            }
        }
        while (!stack.isEmpty()){
            array.add(stack.pop());
        }
        for (int i=0; i<array.size()-2;i++){
            if (array.get(i) > array.get(i+1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int nums = sc.nextInt();
            array.add(nums);
        }
        if (check(array)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}

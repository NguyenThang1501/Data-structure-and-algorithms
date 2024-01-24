package streetParade;

import java.util.Scanner;
import java.util.Stack;

public class test {
    public static boolean check(int[] arr, int n) {
        if (n == 0) {
            return false;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                stack1.push(arr[i]);
            } else {
                stack2.push(arr[i]);
            }

            while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() - stack2.peek() == 1 ) {
                stack2.push(stack1.pop());
            }

        }
        stack2.push(arr[arr.length - 1]);
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        for (int i = n; i >= 1; i--) {
            if (stack2.pop() != i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n!=0){
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            if (check(array, n)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            n = sc.nextInt();
        }

    }
}

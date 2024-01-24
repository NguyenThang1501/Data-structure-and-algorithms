package easyStack;

import java.util.Scanner;
import java.util.Stack;

public class EasyStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        int n = sc.nextInt();
        sc.nextLine();
        if (n <= 0) {
            System.out.println("Empty!");
        } else {
            String str;
            for (int i = 0; i < n; i++) {
                str = sc.nextLine().trim();
                if (str.charAt(0) == '1') {
                    stack.push(str.substring(2));
                }
                if (str.equals("2")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
                if (str.equals("3")) {
                    if (!stack.isEmpty()) {
                        System.out.println(stack.peek());
                    } else {
                        System.out.println("Empty!");
                    }
                }
            }
        }
    }
}

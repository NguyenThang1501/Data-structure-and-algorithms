package Hw4_21002174.stack.exercise3;

import java.util.Scanner;
import java.util.Stack;

public class ktraDauNgoac {
    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static int calculate(char ch, int a, int b) {
        if (ch == '+') {
            return a + b;
        }
        if (ch == '–') {
            return a - b;
        }
        if (ch == '*') {
            return a * b;
        }
        if (ch == '/') {
            return a / b;
        }
        return 0;
    }

    public static int value(String str) {
        Stack<Integer> stackNumber = new Stack<>();
        Stack<Character> stackDau = new Stack<>();
        char[] elements = str.toCharArray();
        int s = 0;
        int i = 0;
        while (i < elements.length) {
            if (Character.isDigit(elements[i])) {
                StringBuilder st = new StringBuilder();
                while (Character.isDigit(elements[i])) {
                    st.append(elements[i]);
                    i++;
                }
                stackNumber.push(Integer.parseInt(st.toString()));
                i--;
            }
            if (elements[i] == '+' || elements[i] == '–' || elements[i] == '*' || elements[i] == '/') {
                stackDau.push(elements[i]);
            }
            if (elements[i] == ')') {
                int a = stackNumber.pop();
                int b = stackNumber.pop();
                s = calculate(stackDau.pop(), b, a);
                stackNumber.push(s);
            }
            i++;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        System.out.println(check(exp));
        if (check(exp)) {
            System.out.println(value(exp));
        }
    }
}

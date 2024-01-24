package transformExpression;

import java.util.Scanner;
import java.util.Stack;

public class ONP {
    public static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public static String transformExpression(String exp){
        Stack<Character> st = new Stack<>();
        String outputString = "";
        char[] strChar = exp.toCharArray();

        for (char t : strChar) {
            if (Character.isLetterOrDigit(t)) {
                outputString += t;
            } else if (t == '(') {
                st.push(t);
                System.out.println(st.toString());
            } else if (t == ')') {
                while (!st.empty() && st.peek() != '(') {
                    outputString += st.pop();
                    System.out.println(st.toString());
                }
                if (!st.empty() && st.peek() != '(') {
                    throw new IllegalArgumentException();
                } else {
                    st.pop();
                    System.out.println(st.toString());
                }
            } else {
                while (!st.empty() && Prec(t) <= Prec(st.peek())) {
                    outputString += st.pop();
                }
                st.push(t);
                System.out.println(st.toString());
            }
        }
        while (!st.empty()) {
            outputString += st.pop();
            System.out.println(st.toString());
            System.out.println("hhhh"+ outputString);
        }
        return outputString;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String exp = sc.nextLine();
            System.out.println(transformExpression(exp));
        }
    }
}

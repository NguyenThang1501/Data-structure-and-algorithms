package transformExpression;

import java.util.Stack;

public class test {
    public static int prec(char c){
        switch (c){
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
        Stack<Character> stack = new Stack<>();
        String result = "";
        char[] strChar = exp.toCharArray();

        for (char c: strChar){
            if (Character.isLetterOrDigit(c)){
                result +=c;
            } else if (c =='(') {
                stack.push(c);
            } else if (c==')') {
                while (!stack.isEmpty() && stack.peek() !='('){
                    result += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != '('){
                    throw new IllegalArgumentException();
                }else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && prec(c) <= stack.peek()){
                    result+=stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
}

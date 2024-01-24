package transformExpression;

import java.util.Scanner;
import java.util.Stack;

public class again {
    public static String transform(String exp){
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (char c: exp.toCharArray()){
            if (Character.isLetterOrDigit(c)){
                ans.append(c);
            }
            if (c == '+' || c == '-' || c == '*' || c=='/' || c =='^'){
                st.push(c);
            }
            if (c==')' && !st.isEmpty()){
                ans.append(st.pop());
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0; i<t; i++){
            String exp = sc.next();
            System.out.println(transform(exp));

        }
    }
}

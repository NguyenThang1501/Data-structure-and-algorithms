import java.util.Stack;

public class ONP {

    public static String RPNform(String exp){
        Stack<Character> stack = new Stack();
        for (char c: exp.toCharArray()){
            if (Character.isAlphabetic(c)){
                stack.push(c);
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        String s = "a+(b*c)";
        System.out.println(RPNform(s));
    }




}

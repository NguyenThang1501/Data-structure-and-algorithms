import java.util.Stack;

class Main
{
    // Function to check if given expression is balanced or not
    public static boolean balParenthesis(String exp)
    {
        // base case: length of the expression must be even
        if (exp.length() % 2 == 1) {
            return false;
        }

        // take an empty stack of characters
        Stack<Character> stack = new Stack();

        // traverse the input expression
        for (char c: exp.toCharArray())
        {
            // if current char in the expression is an opening brace,
            // push it to the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            // if current char in the expression is a closing brace
            if (c == ')' || c == '}' || c == ']')
            {
                // return false if mismatch is found (i.e. if stack is empty,
                // the number of opening braces is less than number of closing
                // brace, so expression cannot be balanced)
                if (stack.empty()) {
                    return false;
                }

                // pop character from the stack
                Character top = stack.pop();

                // if the popped character if not an opening brace or does not pair
                // with current character of the expression
                if ((top == '(' && c != ')') || (top == '{' && c != '}')
                        || (top == '[' && c != ']')) {
                    return false;
                }
            }
        }

        // expression is balanced only if stack is empty at this point
        return stack.empty();
    }

    public static void main(String[] args)
    {
        String exp = "{()}[{]}";

        if (balParenthesis(exp)) {
            System.out.println("The expression is balanced");
        } else {
            System.out.println("The expression is not balanced");
        }
    }
}
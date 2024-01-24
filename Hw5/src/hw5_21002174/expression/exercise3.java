package hw5_21002174.expression;

import hw5_21002174.binarytree.exercise1_2.LinkedBinaryTree;

import java.util.Stack;

public class exercise3 extends exercise2_1 {


    // Chuyen tu dang trung to sang hau to
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

    //Dung cay nhi phan
    public static LinkedBinaryTree toTree(String exp){
        LinkedBinaryTree tree = new LinkedBinaryTree();
        Stack<Node> st = new Stack<>();

        for (char c : exp.toCharArray()){
            Node newNode = new Node<>(c,null,null,null);
            if (Character.isLetter(c)){
                st.push(newNode);
            }
            if (c=='+' || c == '-' || c=='*' || c=='/'){
                Node right = st.pop();
                Node left = st.pop();

                newNode.setRight(right);
                newNode.setLeft(left);

                st.push(newNode);
            }
        }
        Node root = st.pop();
        tree.addRoot(root);
        System.out.println(root.getRight().getElement());
        return tree;
    }

    public static void main(String[] args) {

        String test = "((a+(b*c))+((f+d)*g))";
        System.out.println(transform(test));

        String exp = "abc*+fd+g*+";
        LinkedBinaryTree tree = toTree(exp);
    }
}

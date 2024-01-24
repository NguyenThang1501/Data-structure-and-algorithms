package hw5_21002174.expression;

import hw5_21002174.binarytree.exercise1_2.LinkedBinaryTree;

public class exercise2_1<E> extends LinkedBinaryTree {
    public void preorderPrint(Node<E> p) {
    //pre-order traversal of tree with root p
        if (p == null){
            return;
        }
        System.out.println(p.getElement());
        preorderPrint(p.getLeft());
        preorderPrint(p.getRight());
    }

    public void postorderPrint(Node<E> p) {
    //post-order traversal of tree with root p
        if (p == null){
            return;
        }
        postorderPrint(p.getLeft());
        postorderPrint(p.getRight());
        System.out.println(p.getElement());
    }
    public void inorderPrint(Node<E> p) {
    //in-order traversal of tree with root p
        if (p == null) return;
        inorderPrint(p.getLeft());
        System.out.println(p.getElement());
        inorderPrint(p.getRight());
    }
}

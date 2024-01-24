package hw5_21002174.expression;

public class exercise2_2<E> extends exercise2_1<E> {

    public static void printInorder(Node p) {
        if (p.getLeft() != null){
            System.out.print("(");
            printInorder(p.getLeft());
        }
        System.out.print(p.getElement());
        if (p.getRight() != null){
            printInorder(p.getRight());
            System.out.print(")");
        }
    }

    public static void printPostorder(Node p) {
        if (p.getLeft() != null){
            printPostorder(p.getLeft());
        }

        if (p.getRight() != null){
            printPostorder(p.getRight());
        }
        System.out.print(p.getElement());
    }

    public static void printPreorder(Node p) {
        System.out.print(p.getElement());
        if (p.getLeft() != null){
            printPreorder(p.getLeft());
        }

        if (p.getRight() != null){
            printPreorder(p.getRight());
        }

    }

    public static void main(String[] args) {
        Node root = new Node<>('+', null,null,null);

        exercise2_2 t = new exercise2_2();
        t.addRoot(root);
        t.addLeft(root,'+');
        t.addRight(root,'*');

        t.addLeft(root.getLeft(),'a');
        t.addRight(root.getLeft(),'*');

        t.addLeft(root.getRight(),'+');
        t.addRight(root.getRight(),'g');

        t.addLeft(root.getLeft().getRight(),'b');
        t.addRight(root.getLeft().getRight(),'c');

        t.addLeft(root.getRight().getLeft(),'f');
        t.addRight(root.getRight().getLeft(),'d');


        printInorder(root);
        System.out.println();
        printPostorder(root);
        System.out.println();
        printPreorder(root);
    }
}

package hw5_21002174.binarytree.exercise1_3;

public class Main {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    class TreePrinter {
        public static void print(Node root) {
            printTree(root, "");
        }

        private static void printTree(Node node, String prefix) {
            if (node == null) {
                return;
            }

            printTree(node.right, prefix + "    ");
            System.out.println(prefix  + node.value);
            printTree(node.left, prefix + "    ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        TreePrinter.print(root);
    }

}

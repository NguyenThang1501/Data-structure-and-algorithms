package hw5_21002174.binarytree.exercise1_2;

public class LinkedBinaryTree<E> implements BinaryTreeInterface<E> {

    protected static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            this.element = e;
            this.parent = above;
            this.left = leftChild;
            this.right = rightChild;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }
    protected Node<E> root = null;
    private int size = 0;

    public E root() {
        return root.getElement();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Node<E> addRoot(E element) {
        Node root = new Node<>(element, null, null, null);
        size = 1;
        return root;
    }

    public Node<E> addLeft(Node p, E element) {
        Node parent = p;
        if (p.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");
        Node child = new Node<>(element,parent,null,null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Node<E> addRight(Node p, E element) {
        Node parent = p;
        if (p.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");
        Node child = new Node<>(element,parent,null,null);
        parent.setRight(child);
        size++;
        return child;
    }

    public void set(Node p, E element) {
        p.setElement(element);
    }
}

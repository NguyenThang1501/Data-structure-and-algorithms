package hw5_21002174.binarytree.exercise1_1;


public class ArrayBinaryTree<E> implements BinaryTreeInterface<E> {
    private E[] array;
    private int n = 0;
    private int defaultSize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultSize];
    }

    public void setRoot(E element) {
        array[1] = element;
        if (n == 0) {
            n++;
        } else {
            System.out.println("Tree is not empty");
        }
    }

    public void setLeft(int p, E element) {
        if (2 * p >= array.length || p < 1) {
            return;
        }
        if (array[p] == null) {
            return;
        } else {
            if (array[2 * p] == null) {
                n++;
            }
            array[2 * p] = element;
        }

    }

    public void setRight(int p, E element) {
        if (2 * p + 1 >= array.length || p < 1) {
            return;
        }
        if (array[p] == null) {
            return;
        } else {
            if (array[2 * p + 1] == null) {
                n++;
            }
            array[2 * p + 1] = element;
        }
    }


    @Override
    public E root() {
        if (isEmpty()) {
            return null;
        }
        return array[1];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(E p) {
        int count = 0;
        if (p == null) {
            return 0;
        }
        for (int i = 1; i <= n; i++) {
            if (array[i].equals(p)) {
                if (2 * i < array.length && array[2 * i] != null) {
                    count++;
                }
                if (2 * i + 1 < array.length && array[2 * i + 1] != null) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public E parent(E p) {
        if (p.equals(array[1])) {
            return null;
        }
        for (int i = 2; i <= n; i++) {
            if (array[i].equals(p)) {
                return array[(int) i / 2];
            }
        }
        return null;
    }

    @Override
    public E left(E p) {
        if (p.equals(null)) {
            return null;
        }
        for (int i = 1; i < n; i++) {
            if (array[i].equals(p)) {
                if (2 * i + 1 < n) {
                    return array[2 * i + 1];
                }
            }
        }
        return null;
    }

    @Override
    public E right(E p) {
        if (p.equals(null)) {
            return null;
        }
        for (int i = 1; i < n; i++) {
            if (array[i].equals(p)) {
                if (2 * i < n) {
                    return array[2 * i];
                }
            }
        }
        return null;
    }

    @Override
    public E sibling(E p) {
        for (int i = 1; i < n; i++) {
            if (array[i].equals(p)) {
                if (i % 2 == 0) {
                    return array[i + 1];
                } else {
                    return array[i - 1];
                }
            }
        }
        return null;
    }


}

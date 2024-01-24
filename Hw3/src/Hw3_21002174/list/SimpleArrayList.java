package Hw3_21002174.list;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T data) {
        if (n >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[n] = data;
        n++;
    }

    @Override
    public T get(int i) {
        if (i >= n || i < 0) {
            return null;
        }
        return array[i];
    }

    @Override
    public void set(int i, T data) {
        if (i >= n || i < 0) {
            return;
        }
        array[i] = data;
    }

    @Override
    public void remove(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                for (int j = i; j < n - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[n - 1] = null;
                n--;
            }
        }
    }

    @Override
    public void isContain(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i] == data) {
                System.out.print(i + " ");
            }
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < n; i++) {
            if (array[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private int curPosition = 0;

            @Override
            public boolean hasNext() {
                return curPosition < n || array[curPosition] != null;
            }

            @Override
            public T next() {
                return array[curPosition++];
            }
        };
        return iterator;
    }
}

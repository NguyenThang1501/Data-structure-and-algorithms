package arraylist;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
// Hàm dựng với kích thước mảng là capacity
        this.array = (T[]) new Object[capacity];
    }

    public void add(T data) {
        if (n == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[n] = data;
        n++;
    }

    public T get(int i) {
        if (i >= n) {
            return null;
        }
        return array[i];
    }

    public void set(int i, T data) {
        array[i] = data;
    }

    public void remove(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i] == data) {
                for (int j = i; j < n - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[n - 1] = null;
                n--;
            }
        }
    }

    public boolean isContain(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i] == data) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return n;
    }

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
                return curPosition < n && array[curPosition] != null;
            }

            @Override
            public T next() {
                return array[curPosition++];
            }
        };
        return iterator;
    }
}

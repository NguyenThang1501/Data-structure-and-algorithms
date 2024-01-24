package Hw4_21002174.stack.stackarray;

import java.util.Arrays;
import java.util.Iterator;

public class MyStack<E> implements StackInterface<E> {

    private E[] stackArray;
    private int size;
    private int capacity;

    public MyStack(int capacity) {
        stackArray = (E[]) new Object[capacity];
    }

    @Override
    public void push(E element) {
        if (size >= capacity) {
            stackArray = Arrays.copyOf(stackArray, stackArray.length * 2);
        }
        stackArray[size] = element;
        size++;
    }

    @Override
    public E pop() {
        E value = stackArray[size - 1];
        stackArray[size - 1] = null;
        size--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public E top() {
        return stackArray[size-1];
    }


    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private int curPosition =0;
            @Override
            public boolean hasNext() {
                return curPosition < size || stackArray[curPosition] !=null;
            }

            @Override
            public E next() {
                return stackArray[curPosition++];
            }
        };
        return iterator;
    }
    public void printStack(){
        for (int i=0; i<size;i++){
            System.out.print(stackArray[i]+" ");
        }
        System.out.println();
    }
}

package Hw4_21002174.stack.stacklist;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
        }
    }

    Node stack = null;
    int size = 0;

    public LinkedListStack() {
    }

    @Override
    public void push(E element) {
        Node newNode = new Node(element);
        if (stack == null) {
            stack = newNode;
        } else {
            Node currNode = stack;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            E value = stack.element;
            stack = null;
            size--;
            return value;
        } else {
            Node currNode = stack;
            for (int i = 0; i < size - 2; i++) {
                currNode = currNode.next;
            }
            E value = currNode.next.element;
            currNode.next = null;
            size--;
            return value;
        }
    }

    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        } else {
            Node currNode = stack;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            return currNode.element;
        }

    }

    public Iterator<E> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }


    public void printList() {
        Node currNode = stack;
        while (currNode.next != null) {
            System.out.print(currNode.element + " ");
            currNode = currNode.next;
        }
        System.out.println(currNode.element);
        System.out.println();
    }
}

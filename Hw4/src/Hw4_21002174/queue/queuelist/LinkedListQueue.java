package Hw4_21002174.queue.queuelist;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    class Node {
        E data;
        Node next;

        public String toString() {
            return data.toString();
        }
    }

    private Node top = null;
    private Node bot = null;
    private int size = 0;

    public LinkedListQueue() {
    }
    public int size(){
        return size;
    }

    @Override
    public void enqueue(E element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = null;
        if (top == null) {
            top = bot = newNode;
        }
        bot.next = newNode;
        bot = newNode;
        size++;
    }

    @Override
    public E dequeue() {
        if (top == null) {
            return null;
        }
        Node temp = top;
        top = top.next;
        size--;
        return temp.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    class QueueIterator implements Iterator<E> {
        private Node currentNode = top;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }
    }
}

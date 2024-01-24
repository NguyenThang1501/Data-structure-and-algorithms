package Hw4_21002174.queue.queuearray;
import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;

    public ArrayQueue(int capacity) {
        this.n = capacity;
        queue = (E[]) new Object[capacity];
    }

    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
    }

    @Override
    public void enqueue(E element) {
        if (count == queue.length) {
            throw new IllegalStateException("Queue is full");
        }
        int bot = (top + count) % queue.length;
        queue[bot] = element;
        count++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E revElement = queue[top];
        queue[top] = null;
        top = (top + 1) % queue.length;
        count--;
        return revElement;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;

        @Override
        public boolean hasNext() {
            return num < count;
        }

        @Override
        public E next() {
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }

}

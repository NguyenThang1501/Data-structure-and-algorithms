package Hw4_21002174.queue.queuearray;

public interface QueueInterface<E> extends Iterable<E> {
    public void enqueue(E element);

    public E dequeue();

    public boolean isEmpty();
}

package Hw4_21002174.stack.stacklist;

public interface StackInterface<E> extends Iterable<E> {
    public void push(E element);
    public E pop();
    public boolean isEmpty();
    public E top();
}

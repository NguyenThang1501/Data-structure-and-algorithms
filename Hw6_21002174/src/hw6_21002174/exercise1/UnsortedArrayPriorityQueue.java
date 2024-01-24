package hw6_21002174.exercise1;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public E getValue() {
            return this.element;
        }

        public ArrEntry(K key, E element) {
            this.key = key;
            this.element = element;
        }

        @Override
        public String toString() {
            return key + " " + element;
        }
    }

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultsize = 1000;

    public UnsortedArrayPriorityQueue() {
        this.array = new ArrEntry[defaultsize];
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
    public void insert(Entry<K, E> entry) {

        if (n == defaultsize) {
            throw new ArrayIndexOutOfBoundsException("array is full");
        } else {
            array[n] = new ArrEntry<>(entry.getKey(), entry.getValue());
            n++;
        }
    }

    @Override
    public void insert(K k, E e) {
        if (n == defaultsize) {
            throw new ArrayIndexOutOfBoundsException("array is full");
        } else {
            array[n] = new ArrEntry<>(k, e);
            n++;
        }
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        ArrEntry<K, E> min = new ArrEntry<>(min().getKey(), min().getValue());
        for (int i = 0; i < n; i++) {
            if (min.getKey().compareTo(array[i].getKey()) == 0) {
                for (int j = i; j < n - 1; j++) {
                    array[j] = array[j + 1];
                }
                break;
            }
        }
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        Entry<K, E> min = array[0];
        for (int i = 1; i < n; i++) {
            if (min.getKey().compareTo(array[i].getKey()) > 0) {
                min = array[i];
            }
        }
        return min;
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(array[i].getKey() + " " + array[i].getValue());
        }
    }

}

package hw6_21002174.exercise1;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
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

        public String toString() {
            return this.key + " " + this.element;
        }
    }

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultsize = 1000;

    public SortedArrayPriorityQueue() {
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
            ArrEntry<K, E> newEntry = new ArrEntry<>(entry.getKey(), entry.getValue());
            if (n == 0) {
                array[0] = newEntry;
            } else {
                int index = n - 1;
                while (array[index].getKey().compareTo(newEntry.getKey()) > 0) {
                    index--;
                }
                for (int i = n; i > index + 1; i--) {
                    array[i] = array[i - 1];
                }
                array[index + 1] = newEntry;
            }
            n++;
        }

    }

    @Override
    public void insert(K k, E e) {
        if (n == defaultsize) {
            throw new ArrayIndexOutOfBoundsException("array is full");
        } else {
            ArrEntry<K, E> newEntry = new ArrEntry<>(k, e);
            if (n == 0) {
                array[0] = newEntry;
            } else {
                int index = n;
                while (array[index - 1].getKey().compareTo(newEntry.getKey()) > 0) {
                    index--;
                    if (index == 0) break;
                }
                for (int i = n; i > index; i--) {
                    array[i] = array[i - 1];
                }
                array[index] = newEntry;
            }
            n++;
        }
    }


    @Override
    public Entry<K, E> removeMin() {
        if (n == 0) return null;
        ArrEntry<K, E> min = array[0];
        for (int i = 1; i < n; i++) {
            array[i - 1] = array[i];
        }
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        return array[0];
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(array[i].getKey() + " " + array[i].getValue());
        }
    }
}

package hw6_21002174.exercise1;

public class UnSortedLinkedPriorityQueue<K extends Comparable, E> implements
        PriorityQueueInterface<K, E> {
    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            this.key = k;
            this.element = e;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public E getValue() {
            return this.element;
        }

        public String toString() {
            return this.key + " " + this.element;
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    int n = 0;

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
        NodeEntry newNode = new NodeEntry<>(entry.getKey(), entry.getValue());
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> newNode = new NodeEntry<>(k, e);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (head == null) return null;
        Entry<K, E> minEntry = min();
        if (head.getKey().compareTo(minEntry.getKey()) == 0) {
            head = head.next;
            n--;
        }

        NodeEntry<K, E> currNode = head;
        while (currNode.next != null) {
            if (currNode.next.getKey().compareTo(minEntry.getKey()) == 0) {
                currNode.next = currNode.next.next;
            }
            currNode = currNode.next;
        }
        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (head == null) return null;
        NodeEntry<K, E> currNode = head;
        NodeEntry<K, E> minEntry = head;
        while (currNode.next != null) {
            if (currNode.getKey().compareTo(minEntry.getKey()) < 0) {
                minEntry = currNode;
            }
            currNode = currNode.next;
        }
        return minEntry;
    }

    public void print() {
        NodeEntry<K, E> currNode = head;
        while (currNode.next != null) {
            System.out.println(currNode.getKey() + " " + currNode.getValue());
            currNode = currNode.next;
        }
        System.out.println(tail.getKey() + " " + tail.getValue());
    }
}

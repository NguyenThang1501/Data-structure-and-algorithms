package hw6_21002174.exercise1;

public class SortedLinkedPriorityQueue<K extends Comparable, E> implements
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

    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> newNode = new NodeEntry<>(k, e);
        if (head == null) {
            head = tail = newNode;
            n++;
        } else {
            int index = 0;

            NodeEntry<K, E> preNode = null;
            NodeEntry<K, E> currNode = head;
            while (currNode.getKey().compareTo(newNode.getKey()) < 0) {
                index++;
                if (index == n || currNode.next == null) break;
                preNode = currNode;
                currNode = currNode.next;
            }
            if (index == 0) {
                addHead(k, e);
            } else if (index == n) {
                addTail(k, e);
            } else {
                newNode.next = preNode.next;
                preNode.next = newNode;
                n++;
            }

        }

    }

    public void addHead(K k, E e) {
        NodeEntry<K, E> newNode = new NodeEntry<>(k, e);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        n++;
    }

    public void addTail(K k, E e) {
        NodeEntry<K, E> newNode = new NodeEntry<>(k, e);
        newNode.next = null;
        if (head == null) {
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
        n++;
    }


    @Override
    public Entry<K, E> removeMin() {
        if (head == null) return null;
        NodeEntry<K, E> temp = head;
        head = head.next;
        n--;
        return temp;
    }

    @Override
    public Entry<K, E> min() {
        return head;
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

package Hw3_21002174.linkedlist;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        Node newNode = new Node(data);
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
        n++;
    }

    public void addBot(T data) {
        Node newNode = new Node(data);
        newNode.next = null;
        if (top == null) {
            bot = newNode;
        }
        bot.next = newNode;
        bot = newNode;
        n++;
    }

    public T get(int i) {
        if (i < 0 || i >= n) {
            return null;
        }
        Node currentNode = top;
        for (int j = 0; j < i; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public void set(int i, T data) {
        if (i >= n || i < 0) {
            return;
        }
        Node current = top;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        current.data = data;
    }

    public boolean isContain(T data) {
        Node currentNode = top;
        while (currentNode.next != null) {
            if (currentNode.data == data) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public T removeTop() {
        if (top != null) {
            T dataTop = top.data;
            top = top.next;
            n--;
            return dataTop;
        }
        return null;
    }

    public T removeBot() {
        if (top == null) {
            return null;
        }
        if (n == 1) {
            Node a = top;
            top = bot = null;
            n--;
            return a.data;
        }
        Node currNode = top;
        for (int i = 0; i < n - 2; i++) {
            currNode = currNode.next;
        }
        Node b = bot;
        currNode.next = null;
        n--;
        return b.data;
    }

    public void remove(T data) {
        while (top.data.equals(data)) {
            top = top.next;
            n--;
        }
        Node currentNode = top;
        while (currentNode.next != null) {
            if (currentNode.next.data.equals(data)) {
                currentNode.next = currentNode.next.next;
                n--;
            } else {
                currentNode = currentNode.next;
            }
        }
    }
}

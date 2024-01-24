package hw6_21002174.exercise2;

import hw6_21002174.exercise1.SortedArrayPriorityQueue;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue<K, E> {
    ArrEntry<K, E> heapPQ[];
    int n = 0;
    int defaultSize = 1000;

    public MinHeapPriorityQueue() {
        heapPQ = new ArrEntry[defaultSize];
    }

    protected int parent(int j) {
        return (j - 1) / 2;
    }

    protected int left(int j) {
        return 2 * j + 1;
    }

    protected int right(int j) {
        return 2 * j + 2;
    }

    protected boolean hasLeft(int j) {
        return left(j) < n;
    }

    protected boolean hasRight(int j) {
        return right(j) < n;
    }

    protected void swap(int i, int j) {
        ArrEntry<K, E> temp = heapPQ[i];
        heapPQ[i] = heapPQ[j];
        heapPQ[j] = temp;
    }

    protected void upHeap() {
        int j = n - 1;
        while (j > 0) {
            int p = parent(j);
            if (heapPQ[j].getKey().compareTo(heapPQ[p].getKey()) >= 0) break;
            swap(j, p);
            j = p;
            upHeap();
        }
    }

    protected void downHeap() {
        int j = 0;
        while (hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (heapPQ[leftIndex].getKey().compareTo(heapPQ[rightIndex].getKey()) > 0)
                    smallChildIndex = rightIndex;
            }

            if (heapPQ[smallChildIndex].getKey().compareTo(heapPQ[j].getKey()) >= 0)
                break;

            swap(j, smallChildIndex);
            j = smallChildIndex;
        }

    }

    @Override
    public void insert(K k, E e) {
        if (n == defaultSize) {
            throw new ArrayIndexOutOfBoundsException("array is full");
        } else {
            heapPQ[n] = new ArrEntry(k, e);
            upHeap();
            n++;
        }
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(heapPQ[i].getKey() + " " + heapPQ[i].getValue());
        }
    }

}

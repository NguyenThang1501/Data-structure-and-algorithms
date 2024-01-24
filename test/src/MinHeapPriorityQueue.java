import java.util.Arrays;

public class MinHeapPriorityQueue {
}
import hw6.exercise1.Entry;
        import hw6.exercise1.SortedArrayPriorityQueue;
        import java.util.Arrays;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue<K,E> {
    ArrEntry<K,E>[] heapPQ;
    int n = 0;
    int DEFAULT_SIZE = 100;

    public MinHeapPriorityQueue() {
        heapPQ = (ArrEntry<K, E>[]) new ArrEntry[DEFAULT_SIZE];
    }

    //Các phương thức bổ sung

    private void upHeap() {
        //Vun len
        int index = n;
        while (index > 1 && heapPQ[index / 2].getKey().compareTo(heapPQ[index].getKey()) > 0) {
            swap(index / 2, index);
            index = index / 2;
            upHeap();
        }
    }

    private void downHeap() {
        //Vun xuong
        int index = 1;
        int swapPosition;
        while (index <= n / 2) {
            if (2 * index + 1 <= n) {
                if (heapPQ[2 * index].getKey().compareTo(heapPQ[2 * index + 1].getKey()) < 0) {
                    swapPosition = 2 * index;
                } else {
                    swapPosition = 2 * index + 1;
                }
            } else {
                swapPosition = 2 * index;
            }
            if (heapPQ[index].getKey().compareTo(heapPQ[swapPosition].getKey()) > 0) {
                swap(index, swapPosition);
                index = swapPosition;
            } else
                break;
        }
    }

    public void swap(int i, int j) {
        ArrEntry<K,E> temp = heapPQ[i];
        heapPQ[i] = heapPQ[j];
        heapPQ[j] = temp;
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
        if (n + 1 >= heapPQ.length) {
            heapPQ = Arrays.copyOf(heapPQ, heapPQ.length * 2);
        }
        heapPQ[++n] = (ArrEntry<K, E>) entry;
//        upHeap();
    }

    @Override
    public void insert(K k, E e) {
        insert(new ArrEntry<>(k,e));
    }

    @Override
    public Entry<K, E> removeMin() {
        Entry<K,E> result = heapPQ[1];
        heapPQ[1] = heapPQ[n--];
        downHeap();
        return result;
    }

    @Override
    public Entry<K, E> min() {
        return heapPQ[1];
    }

    public String toString() {
        if (isEmpty())
            return "";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 1; i <= n; i++) {
            sb.append(heapPQ[i].getKey()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("] size = ").append(n);
        return sb.toString();
    }

    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> minHeapPriorityQueue = new MinHeapPriorityQueue<>();
        minHeapPriorityQueue.insert(4, "C");
        minHeapPriorityQueue.insert(5, "A");
        minHeapPriorityQueue.insert(6, "Z");
        minHeapPriorityQueue.insert(15, "K");
        minHeapPriorityQueue.insert(9, "F");
        minHeapPriorityQueue.insert(7, "Q");
        minHeapPriorityQueue.insert(20, "B");
        minHeapPriorityQueue.insert(16, "X");
        minHeapPriorityQueue.insert(25, "J");
        minHeapPriorityQueue.insert(14, "E");
        minHeapPriorityQueue.insert(12, "H");
        minHeapPriorityQueue.insert(11, "S");
        minHeapPriorityQueue.insert(13, "W");
        minHeapPriorityQueue.insert(2,"T");

        System.out.println(minHeapPriorityQueue.toString());
        minHeapPriorityQueue.upHeap();
        System.out.println(minHeapPriorityQueue.toString());
        minHeapPriorityQueue.downHeap();
        System.out.println(minHeapPriorityQueue.toString());
    }
}
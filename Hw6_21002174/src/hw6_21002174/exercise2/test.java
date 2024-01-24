package hw6_21002174.exercise2;

public class test {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> heapPQ = new MinHeapPriorityQueue<>();
        heapPQ.insert(3,"B");
        heapPQ.insert(5,"C");
        heapPQ.insert(1,"A");
        heapPQ.insert(2,"E");
        heapPQ.insert(7,"C");
        heapPQ.insert(6,"T");

        System.out.println("upHeap: ");
        heapPQ.upHeap();
        heapPQ.print();

        System.out.println("downHeap: ");
        heapPQ.downHeap();
        heapPQ.print();
    }
}

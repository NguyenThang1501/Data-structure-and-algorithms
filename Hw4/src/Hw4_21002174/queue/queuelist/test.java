package Hw4_21002174.queue.queuelist;

public class test {
    public static void main(String[] args) {
        LinkedListQueue listQueue = new LinkedListQueue();
        listQueue.enqueue("A");
        listQueue.enqueue("B");
        listQueue.enqueue("C");
        while (!listQueue.isEmpty()){
            System.out.println(listQueue.dequeue());
        }
    }
}

package linkedlist;

public class TestMain {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(1);

        linkedList.printLinkedList();

        linkedList.addBot(9);
        linkedList.addBot(15);
        linkedList.printLinkedList();

        linkedList.set(1,5);
        linkedList.printLinkedList();
        System.out.println(linkedList.isContain(10));
        linkedList.remove(1);
        linkedList.printLinkedList();

    }
}

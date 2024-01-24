package Hw4_21002174.stack.stacklist;

public class TestMain {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack<>();
        stack.push(2);
        stack.push(5);
        stack.push(10);
        stack.printList();
        System.out.println(stack.top());
        System.out.println(stack.pop());
        stack.printList();
    }
}

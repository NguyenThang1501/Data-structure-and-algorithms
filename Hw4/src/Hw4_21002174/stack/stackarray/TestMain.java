package Hw4_21002174.stack.stackarray;

public class TestMain {
    public static void main(String[] args) {
        MyStack myStack = new MyStack<>(2);
        myStack.push(2);
        myStack.push(5);
        myStack.push(7);
        myStack.push(10);
        myStack.printStack();
        myStack.pop();
        myStack.pop();
        myStack.printStack();
        System.out.println(myStack.top());
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.isEmpty());
        myStack.printStack();
    }
}

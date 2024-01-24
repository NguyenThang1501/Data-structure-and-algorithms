package classLeader;

public class test5 {
    class Node {

        int value;
        Node nextNode;

        public Node(int value) {
            this.value = value;
        }
    }

    public class CircularLinkedList {
        private Node head = null;
        private Node tail = null;

        public void addNode(int value) {
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
            } else {
                tail.nextNode = newNode;
            }

            tail = newNode;
            tail.nextNode = head;
        }

        public void deleteNode(int valueToDelete) {
            Node currentNode = head;
            if (head == null) { // the list is empty
                return;
            }
            do {
                Node nextNode = currentNode.nextNode;
                if (nextNode.value == valueToDelete) {
                    if (tail == head) { // the list has only one single element
                        head = null;
                        tail = null;
                    } else {
                        currentNode.nextNode = nextNode.nextNode;
                        if (head == nextNode) { //we're deleting the head
                            head = head.nextNode;
                        }
                        if (tail == nextNode) { //we're deleting the tail
                            tail = currentNode;
                        }
                    }
                    break;
                }
                currentNode = nextNode;
            } while (currentNode != head);
        }
    }

    public static void main(String[] args) {

    }
}

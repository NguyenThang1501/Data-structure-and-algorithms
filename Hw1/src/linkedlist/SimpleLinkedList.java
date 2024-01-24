package linkedlist;

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
        this.n++;

    }

    public void addBot(T data) {

        Node newNode = new Node(data);

        if (top == null) {
            top = new Node(data);
            return;
        }
        newNode.next = null;
        Node lastNode = top;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        this.n++;
        // Thêm phần tử vào cuối danh sách

    }

    public T get(int i) {
        // Lấy phần tử ở vị trí thứ i
        Node currentNode = top;
        int index = 0;
        while (currentNode.next != null && index < i) {
            currentNode = currentNode.next;
            index++;
        }
        return currentNode.data;
    }

    public void set(int i, T data) {
        if (i == 0) {
            top.data = data;
        } else {
            Node newNode = new Node(data);
            Node currentNode = top;
            Node preNode = null;
            int count = 0;
            while (currentNode != null) {
                preNode = currentNode;
                currentNode = currentNode.next;
                count++;
                if (count == i) {
                    preNode.next = newNode;
                    newNode.next = currentNode.next;
                    break;
                }

            }
        }
// Gán giá trị ở vị trí i bằng data
    }

    public boolean isContain(T data) {
        Node currentNode = top;
        while (currentNode.next != null) {
            if (currentNode.data == data) {
                return true;
            }
            currentNode = currentNode.next;
        }
// Kiểm tra trong danh sách có chứa phần tử data hay không?
        return false;
    }

    public int size() {
        Node currentNode = top;
        int count = 0;
        while (currentNode.next != null) {
            count++;
            currentNode = currentNode.next;
        }
// Trả lại thông tin số phần tử có trong danh sách
        return count;
    }

    public boolean isEmpty() {
// Kiểm tra danh sách có rỗng hay không?
        return top == null;
    }

    public T removeTop() {
        if (top != null) {
            T dataTop = top.data;
            top = top.next;
            return dataTop;
        }
// Xóa phần tử ở đầu danh sách, trả lại giá trị data của phần tử đó
        return null;
    }

    public T removeBot() {
        if (top == null) {
            return null;
        }
        Node lastNode = top;
        Node prevNode = null;
        while (lastNode.next != null) {
            prevNode = lastNode;
            lastNode = lastNode.next;
        }
        prevNode.next = lastNode.next;
// Xóa phần tử ở cuối danh sách, trả lại giá trị data của phần tử đó

        return lastNode.data;
    }

    public void remove(T data) {
// Xóa tất cả các phần tử có giá trị bằng data
        while (top.data == data){
            top = top.next;
        }
        Node currentNode = top;
        while (currentNode != null && currentNode.next != null){
            if (currentNode.next.data == data){
                currentNode.next = currentNode.next.next;
            }else {
                currentNode = currentNode.next;
            }
        }
    }

    public void printLinkedList() {
        if (this.top == null) {
            System.out.println("List is empty");
        } else {
            Node temp = top;
            while (temp != null) {
                System.out.print(temp.data);
                temp = temp.next;
                if (temp != null) {
                    System.out.print("->");
                } else {
                    System.out.println();
                }
            }
        }
    }
}
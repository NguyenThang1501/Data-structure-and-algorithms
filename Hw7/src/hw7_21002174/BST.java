package hw7_21002174;

import java.util.Arrays;
import java.util.Stack;

public class BST {

    //1. Kiểm tra một dãy có là dãy duyệt giữa của cây tìm kiếm nhị phân
    boolean isRepresentingBST(int a[], int N) {
        for (int i = 0; i + 1 < N; i++) {
            if (a[i] >= a[i + 1])
                return false;
        }
        return true;
    }

    static class Node {
        int data;
        Node left, right;

        public Node(){

        }
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    int[] a = new int[100000];
    int size = 0;
    Node root = null;

    public void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        a[size++] = root.data;
        inOrder(root.right);
    }

    // 2. Kiểm tra một cây có là cây tìm kiếm nhị phân
    public boolean isBST(Node root) {
        if (root == null) return true;
        inOrder(root);
        for (int i = 0; i + 1 < size; i++) {
            if (a[i] >= a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    //3. Tìm median của cây tìm kiếm nhị phân
    public double findMedian(Node root) {
        inOrder(root);
        if (size % 2 == 0)
            return a[size / 2];
        else
            return (a[size / 2] + a[size / 2 - 1]) / 2.0;
    }

    // 4. Đếm các giá trị của cây trong khoảng cho trước
    public int countNodes(Node root, int l, int h) {
        inOrder(root);
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] >= l && a[i] <= h) {
                count++;
            }
        }
        return count;
    }

    //5. Phần tử nhỏ nhất thứ k trong cây tìm kiếm nhị phân
    public int kSmallest(Node root, int k) {
        inOrder(root);
        return a[k];
    }

    //6. Phần tử lớn thứ k trong cây tìm kiếm nhị phân
    public int kLargest(Node root, int k) {
        inOrder(root);
        return a[size - 1 - k];
    }

    //searching algorithms

    //1. Phần tử bé nhất trên cây tìm kiếm nhị phân
    public int minValue(Node root) {
        if (root == null) return -1;
        while (root.left != null) root = root.left;
        return root.data;
    }

    //2. Tìm phần tử liền sau của một node trên cây tìm kiếm nhị phân
    Node inOrderSuccessor(Node root, Node x) {
        Node successor = null;

        while (root != null) {
            if (root.data <= x.data)
                root = root.right;
            else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    //3. Tìm phần tử liền trước và liền sau của của một phần tử trên cây tìm kiếm nhị phân

    Node pre = new Node();
    Node suc = new Node();
    public void findPreSuc(Node root, int key){
        if (root == null) return;
        if (root.data == key){
            if (root.left != null){
                Node tmp = root.left;
                while (tmp.right != null)
                    tmp = tmp.right;

                pre = tmp;
            }

            if (root.right != null)
            {
                Node tmp = root.right;

                while (tmp.left != null)
                    tmp = tmp.left;

                suc = tmp;
            }
            return;
        }

        if (root.data > key)
        {
            suc = root;
            findPreSuc(root.left, key);
        }
        else
        {
            pre = root;
            findPreSuc(root.right, key);
        }
    }

    //4. Tìm giá trị phần tử lớn nhất trên cây tìm kiếm nhị phân mà không vượt quá N
    public int findMaxForN(Node root, int N)
    {
        if (root == null)
            return -1;
        if (root.data == N)
            return N;
        else if (root.data < N) {
            int k = findMaxForN(root.right, N);
            if (k == -1)
                return root.data;
            else
                return k;
        }
        else {
            return findMaxForN(root.left, N);
        }
    }
    //5. Tìm số bé nhất trên cây tìm kiếm nhị phân mà có giá trị lớn hơn hoặc bằng một giá trị cho trước
    public int findCeil(Node root, int key) {
        if (root == null) return -1;
        if (root.data == key) return root.data;
        if (root.data < key) return findCeil(root.right, key);
        int ceilValue = findCeil(root.left, key);
        if (ceilValue >= key)
            return ceilValue;
        else
            return root.data;
    }

    // Các phép toán trên cây tìm kiếm nhị phân

    //1. Tìm kiếm
    public boolean search(Node root, int x) {
        if (root == null) return false;
        if (root.data == x) return true;
        if (x < root.data)
            return search(root.left, x);
        else
            return search(root.right, x);
    }

    //2. Thêm phẩn tử
    public Node insert(Node root, int key) {
        if (root == null)
            return (new Node(key));
        if (root.data > key) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    //3. Xóa phần tử
    public int suc(Node root) {
        Node temp = root;
        temp = temp.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.data;
    }

    public Node deleteNode(Node root, int x) {
        if (root == null) return null;
        if (root.data > x) {
            root.left = deleteNode(root.left, x);
        } else if (root.data < x) {
            root.right = deleteNode(root.right, x);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.data = suc(root);
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    //4. Xóa mọi phần tử có giá trị lớn hơn k trong cây tìm kiếm nhị phân
    public Node removeNode(Node root, int k){
        if (root == null) return null;
        if (root.data >=k) {
            root.left = removeNode(root.left, k);
            root.right = removeNode(root.right, k);
        }

        if (root.data >=k){
            Node temp = root.left;

        }
        return root;
    }
    //5. Thay đổi khóa phần tử
    public Node changeKey(Node root, int old_key, int new_key)
    {
        root = deleteNode(root, old_key);
        root = insert(root, new_key);
        return root;
    }

    // Biến đổi một cây sang cây tìm kiếm nhị phân

    class index
    {
        int x = 0;
    }
    void arrayToBST(int arr[], Node root, index index_ptr)
    {
        if(root == null)
            return ;

        arrayToBST(arr, root.left, index_ptr);
        root.data = arr[index_ptr.x];
        index_ptr.x++;
        arrayToBST(arr, root.right, index_ptr);
    }
    void storeInorder(Node node, int inorder[], index index_ptr)
    {
        //int index_ptr = 0;
        if(node == null)
            return ;

        storeInorder(node.left, inorder, index_ptr);
        inorder[index_ptr.x] = node.data;
        index_ptr.x++;
        storeInorder(node.right, inorder, index_ptr);
    }
    int countNodes(Node root)
    {
        if(root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right)+1;
    }
    Node binaryTreeToBST (Node root)
    {
        if(root == null)
            return null;

        int n = countNodes(root);

        int arr[] = new int[n];
        index index = new index();
        storeInorder(root, arr,index);

        Arrays.sort(arr);
        index.x = 0;
        arrayToBST(arr, root, index);
        return root;
    }

    // Kiểm tra một dãy có là kết quả của phép duyệt trước trên cây tìm kiếm nhị phân
    public int canRepresentBST(int[] arr, int N) {
        // Create an empty stack
        Stack<Integer> s = new Stack<Integer>();
        int root = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] < root) return 0;
            while (!s.isEmpty() && s.peek() < arr[i]) {
                root = s.peek();
                s.pop();
            }
            s.push(arr[i]);
        }
        return 1;
    }
    // Tạo cây tìm kiếm nhị phân từ các phép duyệt sau
    public int ind;
    public Node make(int post[],int key,int Min,int Max)
    {
        if(ind<0)
            return null;
        Node root=null;
        if(key>Min && key<Max)
        {
            root=new Node(key);
            if(ind-1<0)
                return root;
            ind--;
            if(ind>=0)
            {
                root.right=make(post,post[ind],key,Max);
                root.left=make(post,post[ind],Min,key);
            }
        }
        return root;
    }
    public Node constructTree(int post[],int n)
    {
        ind = n - 1;
        Node root=make(post,post[ind],Integer.MIN_VALUE,Integer.MAX_VALUE);
        return root;
    }

    // Chuyển đổi phép duyệt tiền tố thành hậu tố

    public static Node post_order(int pre[], int size)
    {
        Node root = new Node(pre[0]);
        Stack<Node> s = new Stack<Node>();
        s.push(root);
        for (int i = 1; i < size; ++i)
        {
            Node temp = null;
            while (!s.isEmpty() && pre[i] > s.peek().data)
            {
                temp = s.pop();
            }
            if (temp != null)
            {
                temp.right = new Node(pre[i]);
                s.push(temp.right);
            }
            else
            {
                s.peek().left = new Node(pre[i]);
                s.push(s.peek().left);
            }
        }
        return root;
    }
}

package hw6_21002174.exercise1;

public class test {
    public static void main(String[] args) {
        //test for unsortedArrayPriorityQueue
        UnsortedArrayPriorityQueue<Integer,String> pq = new UnsortedArrayPriorityQueue<>();
        pq.insert(1,"A");
        pq.insert(4,"C");
        pq.insert(3,"B");

        pq.removeMin();
        //pq.print();
        //System.out.println(pq.min().toString());

        //test for sortedArrayPriorityQueue
        SortedArrayPriorityQueue<Integer,String> pq1 = new SortedArrayPriorityQueue<>();
        pq1.insert(3,"C");
        pq1.insert(2,"A");
        pq1.insert(6,"K");


        pq1.removeMin();
        //pq1.print();

        //System.out.println(pq1.min().toString());

        //Test for unSortedLinedPriorityQueue
        UnSortedLinkedPriorityQueue<Integer,String> pq2 = new UnSortedLinkedPriorityQueue<>();
        pq2.insert(4,"D");
        pq2.insert(1,"B");
        pq2.insert(5,"F");
        pq2.insert(2,"A");

//        pq2.print();
//        System.out.println(pq2.min());
//        pq2.removeMin();
//        System.out.println();
//        pq2.print();

        //test for sortedLinkedPriorityQueue
        SortedLinkedPriorityQueue<Integer,String> pq3 = new SortedLinkedPriorityQueue<>();
        pq3.insert(3,"C");
        pq3.insert(2,"A");
        pq3.insert(6,"K");
        pq3.insert(4,"B");
        pq3.insert(5,"D");
        pq3.insert(1,"E");

        pq3.print();
        pq3.removeMin();
        System.out.println();
        pq3.print();
        System.out.println(pq3.min());
    }
}

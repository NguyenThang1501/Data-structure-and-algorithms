package Hw3_21002174.list;

public class Test {
    public static void main(String[] args) {
        SimpleArrayList simpleArrayList = new SimpleArrayList<>();
        simpleArrayList.add(2);
        simpleArrayList.add(30);
        simpleArrayList.add(2);
        simpleArrayList.add(3);
        simpleArrayList.remove(2);
        System.out.println(simpleArrayList.size());
    }
}

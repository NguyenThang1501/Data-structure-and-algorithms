package hw5_21002174.expression;

public class exercise2_3<E> extends exercise2_1 {

    public static int calculate(char c, int a, int b){
        if (c == '+'){
            return a+b;
        }
        if (c=='-'){
            return a-b;
        }
        if (c == '*'){
            return a*b;
        }
        if (c == '/'){
            return a/b;
        }
        return 0;
    }
    //Using post-order
    public static int evaluate(Node p){
        if (p.getLeft() == null){
            return Integer.parseInt(p.getElement().toString()) ;
        }else {
            int x = evaluate(p.getLeft());
            int y = evaluate(p.getRight());
            int z = calculate((char) p.getElement(),x,y);
            return z;
        }
    }

    public static void main(String[] args) {
        Node root = new Node<>('+', null,null,null);

        exercise2_3 t = new exercise2_3();
        t.addRoot(root);
        t.addLeft(root,'+');
        t.addRight(root,'*');

        t.addLeft(root.getLeft(),'1');
        t.addRight(root.getLeft(),'*');

        t.addLeft(root.getRight(),'+');
        t.addRight(root.getRight(),'1');

        t.addLeft(root.getLeft().getRight(),'1');
        t.addRight(root.getLeft().getRight(),'1');

        t.addLeft(root.getRight().getLeft(),'1');
        t.addRight(root.getRight().getLeft(),'1');

        System.out.println(evaluate(root));
    }
}

package genericArray;

public class GenericArray<E> {
    private E[] genericArray;
    private int size;

    public GenericArray(int size) {
        this.size = size;
        genericArray = (E[]) new Object[size];
    }

    public E getElement(int i) {
        return genericArray[i];
    }

    public void setElement(int i, E value) {
        genericArray[i] = value;
    }


    public void printArrayGeneric() {
        for (E element : genericArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public boolean search(E value) {
        for (E element : genericArray) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

}

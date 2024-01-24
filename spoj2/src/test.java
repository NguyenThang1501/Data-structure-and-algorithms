import java.util.*;
import java.lang.*;

class test {
    public static void main(String[] args) throws java.lang.Exception {
        int[] array = {1,2,3,4,5};
        int[] a = Arrays.copyOfRange(array,0,2);
        for (int i=0; i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}

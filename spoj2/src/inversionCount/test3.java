package inversionCount;

import java.util.Scanner;

public class test3 {
    static long count;
    static long[] arr = new long[200001];

    public static void merge(int p, int q, int r) {

        //first array has indices from p to q
        //second array has indices from q to p
        int i, li, ri, n1, n2;
        n1 = q - p + 1;
        n2 = r - q;
        /*
            0....7 : 8 phtu
            q = 3
            n1 = 3 - 0 + 1 = 4
            n2 = 7 - 4 = 3
            --> Chia mảng ban đầu thành 2 mảng có số phẩn tử ~ nhau
        */
        long[] lt = new long[n1];
        long[] rt = new long[n2];//[q-(r+1)+1]
        for (i = 0; i < n1; i++) {
            lt[i] = arr[p + i];
        }
        for (i = 0; i < n2; i++) {
            rt[i] = arr[q + 1 + i];
        }

        //left and right array is ready which is all ready sorted
        //now we will merge
        li = ri = 0;
        i = p;
        // Trộn
        while (li < n1 && ri < n2) {
            if (lt[li] > rt[ri]) {
                arr[i++] = rt[ri++];
                count = count + n1 - li;
            } else //right hand side elemnt is greater that is inversion pair
            {
                arr[i++] = lt[li++];
            }
        }
//inversion pairs have been counted till this stage, do not count again;
        while (li < n1) {
            arr[i++] = lt[li++];

        }

        while (ri < n2) {
            arr[i++] = rt[ri++];
        }

    }

    static void mergesort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2; // Tìm phần tử middle
            mergesort(p, q); // Đệ quy nửa trc
            mergesort(q + 1, r); // Đệ quy nửa sau
            merge(p, q, r); // Trộn hai nửa lại
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        // long[] result = new long[t];
        for (int i = 0; i < t; i++) {
            count = 0;
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextLong();
            }
            mergesort(0, n - 1);
            System.out.println(count);
        }
    }
}

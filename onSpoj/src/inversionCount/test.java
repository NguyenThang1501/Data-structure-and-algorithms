package inversionCount;

public class test {
    static long count;
    static long[] arr = new long[200001];

    public static void merge(int p, int q, int r) {
        int i, li, ri, n1, n2;
        n1 = q - p + 1;
        n2 = r - q;
        long[] lt = new long[n1];
        long[] rt = new long[n2];
        for (i = 0; i < n1; i++) {
            lt[i] = arr[p + i];
        }
        for (i = 0; i < n2; i++) {
            rt[i] = arr[q + 1 + i];
        }

        li = ri = 0;
        i = p;
        while (li < n1 && ri < n2) {
            if (lt[li] > rt[ri]) {
                arr[i++] = rt[i++];
                count = count + n1 - li;
            } else {
                arr[i++] = lt[li++];
            }
        }

        while (li < n1) {
            arr[i++] = lt[li++];
        }
        while (ri < n2) {
            arr[i++] = rt[ri++];
        }

    }

    static void mergesort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergesort(p, q);
            mergesort(q + 1, r);
            merge(p, q, r);
        }
    }
}

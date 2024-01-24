public class Preprocess {
    // preprocessing for strong good suffix rule
    static void preprocess_strong_suffix(int []shift, int[] bpos,
                                         char []pat, int m)
    {
        // m is the length of pattern

        int i = m, j = m + 1;
        bpos[i] = j;

        while(i > 0)
        {
        /*nếu kí tự tại i-1 khác j-1 thì tiếp
        tục dịch sang bên phải mẫu để tìm kiếm đường viền */
            while(j <= m && pat[i - 1] != pat[j - 1])
            {
            /* Ký tự trước sự xuất hiện của t trong P khác
            kí tự mismatching trong P, ta dừng lại việc bỏ qua
            các lần xuất hiện và dịch mẫu từ i sang j */
                if (shift[j] == 0)
                    shift[j] = j - i;

                //Update the position of next border
                j = bpos[j];
            }
        /* p[i-1] matched with p[j-1], border is found.
        store the beginning position of border */
            i--; j--;
            bpos[i] = j;
        }
    }

    static void preprocess_case2(int []shift, int []bpos,
                                 char []pat, int m)
    {
        int i, j;
        j = bpos[0];
        for(i = 0; i <= m; i++)
        {
        /* set the border position of the first character
        of the pattern to all indices in array shift
        having shift[i] = 0 */
            if(shift[i] == 0)
                shift[i] = j;

        /* suffix becomes shorter than bpos[0],
        use the position of next widest border
        as value of j */
            if (i == j)
                j = bpos[j];
        }
    }

    public static void main(String[] args) {
        char []pat = "ABBABAB".toCharArray();
        int m = pat.length;
        int[] shift = new int[m+1];
        int []bpos = new int[m+1];
        preprocess_strong_suffix(shift,bpos,pat,m);
        for (int i =0 ; i<bpos.length;i++){
            System.out.println(i + "..." + bpos[i]);
        }
        System.out.println("shift");
        for (int i =0 ; i<shift.length;i++){
            System.out.println(i + "..." + shift[i]);
        }
        System.out.println("after case 2: ");
        preprocess_case2(shift,bpos,pat,m);
        for (int i =0 ; i<shift.length;i++){
            System.out.println(i + "..." + shift[i]);
        }
    }
}

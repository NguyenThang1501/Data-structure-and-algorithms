public class GoodSuffixHeuristic {
    static void preprocess_strong_suffix(int []shift, int []bpos,
                                         char []pat, int m)
    {
        int i = m, j = m + 1;
        bpos[i] = j;

        while(i > 0)
        {
            while(j <= m && pat[i - 1] != pat[j - 1])
            {
                if (shift[j] == 0)
                    shift[j] = j - i;
                j = bpos[j];
            }
            i--; j--;
            bpos[i] = j;
        }
    }

    //Preprocessing for case 2
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

    static void search(char []text, char []pat) {
        // s is shift of the pattern
        // with respect to text
        int s = 0, j;
        int m = pat.length;
        int n = text.length;

        int[] bpos = new int[m + 1];
        int[] shift = new int[m + 1];

        //initialize all occurrence of shift to 0
        for (int i = 0; i < m + 1; i++)
            shift[i] = 0;

        //do preprocessing
        preprocess_strong_suffix(shift, bpos, pat, m);
        preprocess_case2(shift, bpos, pat, m);

        while (s <= n - m) {
            j = m - 1;

        /* Keep reducing index j of pattern while
        characters of pattern and text are matching
        at this shift s*/
            while (j >= 0 && pat[j] == text[s + j])
                j--;

        /* If the pattern is present at the current shift,
        then index j will become -1 after the above loop */
            if (j < 0) {
                System.out.printf("pattern occurs at shift = %d\n", s);
                s += shift[0];
            } else

            /*pat[i] != pat[s+j] so shift the pattern
            shift[j+1] times */
                s += shift[j + 1];
        }
    }

    public static void main(String[] args) {
        char []text = "ABAAAABAACD".toCharArray();
        char []pat = "ABA".toCharArray();
        search(text, pat);
    }
}

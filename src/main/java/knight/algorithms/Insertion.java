package knight.algorithms;
//import edu.princeton.cs.algs4.*;

public class Insertion extends SortBase
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i = 1; i < N; i++)
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }
}

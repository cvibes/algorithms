package knight.algorithms;
//import java.util.Iterator;
//import edu.princeton.cs.algs4.*;
public class ArrayStack<Item>
{
    private Item[] a;
    private int N;

    public ArrayStack()
    {
        a = (Item[]) new Object[8];
        N = 0;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    private void resize(int newmax)
    {
        Item[] temp = (Item[]) new Object[newmax];
        for(int i = 0; i < N; i++)
            temp[i] = a[i];

        a = temp;
    }

    public void push(Item item)
    {
        if (N == a.length) resize( 2 * a.length );
        a[N++] = item;
    }

    public Item pop()
    {
        Item item = a[--N];
        a[N] = null;
        if ( N == (a.length / 4) ) resize(a.length / 2);
        return item;
    }
}

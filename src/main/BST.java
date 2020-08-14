public class BST<Key extends Comparable<Key>, Value>
{
    private Node root;

    private class Node
    {
        private Value val;
        private Key   key;
        private Node  right, left;
        private int   N;
        public Node(Key key, Value val, int N)
        {
            this.key = key;
            this.val = val;
            this.N   = N;
        }
    }

    public int size()
    {
        return size(root);
    }

    public int size(Node x)
    {
        if ( x == null ) return 0;
        return x.N;
    }

    public void put(Key key, Value val)
    {
        root = put(root, key ,val);
    }

    public Node put(Node x, Key key, Value val)
    {
        if ( x == null ) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      ( cmp < 0 ) x.left  = put(x.left,  key, val);
        else if ( cmp > 0 ) x.right = put(x.right, key, val);
        else                x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Value get(Key key)
    {
        return get(root, key);
    }

    public Value get(Node x, Key key)
    {
        if ( x == null ) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left,  key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    public int rank(Key key)
    {   return rank(root, key); }

    public int rank(Node x, Key key)
    {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return rank(x.left, key);
        else if (cmp > 0) return size(x.left) + 1 + rank(x.right, key);
        else              return size(x.left);
    }

    public Key select(int n)
    {   return select(root, n).key; }

    public Node select(Node x, int k)
    {
        if (x == null) return null;
        int t = size(x.left);
        if      (t > k) return select(x.left,  k);
        else if (t < k) return select(x.right, k-t-1);
        else            return x;
    }

    public static void main(String[] args)
    {
        BST<Character, Integer> bst = new BST<Character, Integer>();

        bst.put('E', 5);
        bst.put('X', 24);
        bst.put('A', 1);
        bst.put('M', 13);
        bst.put('P', 14);
        bst.put('L', 12);
        bst.put('E', 0);
        //System.out.println(bst.size());
        //System.out.println(bst.root.left.key);
        System.out.println(bst.rank('A'));
        System.out.println(bst.select(3));
    }
}

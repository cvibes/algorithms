package knight.algorithms;
import edu.princeton.cs.algs4.*;

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

    private int size(Node x)
    {
        if ( x == null ) return 0;
        return x.N;
    }

    public void put(Key key, Value val)
    {
        root = put(root, key ,val);
    }

    private Node put(Node x, Key key, Value val)
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

    private Value get(Node x, Key key)
    {
        if ( x == null ) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left,  key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    public int rank(Key key)
    {   return rank(root, key); }

    private int rank(Node x, Key key)
    {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return rank(x.left, key);
        else if (cmp > 0) return size(x.left) + 1 + rank(x.right, key);
        else              return size(x.left);
    }

    public Key select(int n)
    {   
        Node x = select(root, n);
        if ( x == null ) return null;
        return x.key;
    }

    private Node select(Node x, int k)
    {
        if (x == null) return null;
        int t = size(x.left);
        if      (t > k) return select(x.left,  k);
        else if (t < k) return select(x.right, k-t-1);
        else            return x;
    }

    public Key floor(Key key)
    {
	Node x = floor(root, key);
	if (x == null) return null;
	return x.key;
    }

    private Node floor(Node x, Key key)
    {
	if (x == null) return null;
	int cmp = key.compareTo(x.key);
	if (cmp == 0) return x;
	// If key is less than what's in current node, we know for
	// sure that the floor is in the left subtree.
	if (cmp < 0)  return floor(x.left, key);
	// If key is larger then current node, it MIGHT be in the
	// right subtree, and if it's not, then current node IS
	// the floor.
	Node t = floor(x.right, key);
	if (t != null) return t;
	return x;
    }

    public Key min()
    {
	if (root == null) return null;
	return min(root).key;
    }

    private Node min(Node x)
    {
	if (x.left == null) return x;
	return min(x.left);
    }
    
    public void deleteMin()
    {
	root = deleteMin(root);
    }

    private Node deleteMin(Node x)
    {
	if (x      == null) return null;
        if (x.left == null) return x.right;
	x.left = deleteMin(x.left);
	x.N = size(x.left) + size(x.right) + 1;
	return x;
    }

    public void traverse()
    {
	traverse(root);
    }

    private void traverse(Node x)
    {
	if (x == null) return;
	StdOut.print(" <- "); 
	traverse(x.left);
	StdOut.print(" ->  -- ");
	StdOut.print(x.key);
	StdOut.print(" -- ->  ");
	traverse(x.right);
	StdOut.print(" <- ");
    }
	
    public void delete(Key key)
    {
	root = delete(root, key);
    }

    private Node delete(Node x, Key key)
    {
	if (x == null) return null;
	int cmp = key.compareTo(x.key);
	if (cmp < 0) x.left = delete(x.left, key);
	else if (cmp > 0) x.right = delete(x.right, key);
	else {
	    if (x.left  == null) return x.right;
	    if (x.right == null) return x.left;
	    Node t = x;
	    x = min(t.right);

	    x.right = deleteMin(t.right);
	    x.left = t.left;
	}
	x.N = size(x.left) + size(x.right) + 1;
	return x;
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
        StdOut.println(bst.rank('A'));
        StdOut.println(bst.select(3));
    }
}

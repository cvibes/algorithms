package knight.algorithms;
import edu.princeton.cs.algs4.*;
public class App
{
    public static void main(String[] args)
    {
	BST<Character, Integer> tree = new BST<Character, Integer>();
	tree.put('E', 5);
        tree.put('X', 24);
        tree.put('A', 1);
        tree.put('M', 13);
        tree.put('P', 14);
        tree.put('L', 12);
        tree.put('E', 0);
	tree.traverse();
	//tree.delete('M');
	//tree.delete('E');
    }
}

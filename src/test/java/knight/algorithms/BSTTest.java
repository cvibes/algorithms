package knight.algorithms;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Before;
//import org.junit.jupiter.api.Ignore;
import static org.junit.jupiter.api.Assertions.*;

public class BSTTest
{
    private BST<Character, Integer> tree;

    @BeforeEach
    public void initialize()
    {
        tree = new BST<Character, Integer>();
        tree.put('E', 5);
        tree.put('X', 24);
        tree.put('A', 1);
        tree.put('M', 13);
        tree.put('P', 14);
        tree.put('L', 12);
        tree.put('E', 0);
    }

    @Test
    public void testSize()
    {
        assertEquals(6, tree.size(), "BST should have 6 elements");
    }

    @Test
    public void testAdd()
    {
        tree.put('B', 2);
        assertEquals(7, tree.size(), "Adding new element should increment size");
    }

    @Test
    @DisplayName("test Select :)")
    public void testSelect()
    {
        assertEquals('A', tree.select(0), "first element should have Key 'A'");
        assertEquals('M', tree.select(3), "Fourth element should have key 'M'");
        assertEquals('X', tree.select(5), "Sixth element should have key 'X'");
        assertEquals(null, tree.select(6), "Anything beyond BST size should have returned null");
    }

    @Test
    public void testFloor()
    {
	assertEquals('A', tree.floor('A'), "Floor of A is A");
	assertEquals('A', tree.floor('C'), "Floor of C is A");
	assertEquals('E', tree.floor('F'), "Floor of F is E");
	assertEquals('M', tree.floor('N'), "Floor of N is M");
	assertEquals('X', tree.floor('X'), "Floor of X is X");
	assertEquals('X', tree.floor('Z'), "Floor of Z is X");
    }

    @Test
    public void testMin()
    {
	assertEquals('A', tree.min(), "A is the min of BST");
    }
    
    @Test
    public void testDeleteMin()
    {
	assertEquals(6, tree.size(), "BST now has 6 elements");
	tree.deleteMin();
	assertEquals(5, tree.size(), "BST now has 5 elements after deletion");
	assertEquals(null, tree.get('A'), "A is deleted from BST");
	assertEquals('E', tree.min(), "E is now the min of BST");
	tree.deleteMin();
	assertEquals(4, tree.size(), "BST now has 4 elements after 2 deletions");
	assertEquals(null, tree.get('E'), "E has been deleted");
	assertEquals('L', tree.min(), "L is now the min of BST");
	tree.deleteMin();
	tree.deleteMin();
	tree.deleteMin();
	assertEquals(1, tree.size(), "BST now has only 1 element after 3 more deletions");
	assertEquals('X', tree.min(), "X is now the min");
	tree.deleteMin();
	assertEquals(0, tree.size(), "BST has no elements left");
	tree.deleteMin();
	assertEquals(0, tree.size(), "One more deletion does nothing");
    }

    @Test
    public void testDelete()
    {
	tree.delete('M');
	assertEquals(5, tree.size(), "BST shrinks by one after one delete");
	assertEquals('A', tree.min(), "A is still the min");
	assertEquals(null, tree.get('M'), "M does not exist in BST");
	tree.delete('E');
	assertEquals(4, tree.size(), "BST shrinks by one after one more delete");
	assertEquals('A', tree.min(), "A is still the min");
	assertEquals(null, tree.get('E'), "E does not exist in BST");
	tree.traverse();
    }
}

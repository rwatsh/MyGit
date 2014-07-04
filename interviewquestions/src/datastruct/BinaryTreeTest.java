package datastruct;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void test() {
		BinaryTree tree = new BinaryTree(new Integer[] {10, 5, 15, 12, 4, 8 });

	    System.out.print("\nInorder: ");
	    tree.inorder();
	    System.out.print("\nPreorder: ");
	    tree.preorder();
	    System.out.print("\nPostorder: ");
	    tree.postorder();

	    //call the breadth method to test it

	    System.out.print("\nBreadthFirst:");
	    tree.breadth();
	    System.out.print("\nDepthFirst:");
	    tree.depthFirst();
	    System.out.println("\nTree depth: " + tree.depth());
	}

}

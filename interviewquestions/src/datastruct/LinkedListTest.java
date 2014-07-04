package datastruct;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testAdd() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(2);
		String listContents = list.print();
		Assert.assertEquals("[1,2,2]", listContents);
	}

	@Test
	public void testRemoveHead() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.remove(1);
		String listContents = list.print();
		Assert.assertEquals("[2,2]", listContents);
	}
	
	@Test
	public void testRemoveAll() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.remove(1);
		list.remove(2);
		list.remove(2);
		String listContents = list.print();
		Assert.assertEquals("[]", listContents);
	}
}

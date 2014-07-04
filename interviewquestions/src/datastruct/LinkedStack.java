package datastruct;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<Item> implements Iterable<Item> {
	private int size; // size of the stack
	private Node<Item> top; // top of stack

	// helper linked list class
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	/**
	 * Initializes an empty stack.
	 */
	public LinkedStack() {
		top = null;
		size = 0;
	}

	/**
	 * Is this stack empty?
	 * 
	 * @return true if this stack is empty; false otherwise
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * Returns the number of items in the stack.
	 * 
	 * @return the number of items in the stack
	 */
	public int size() {
		return size;
	}

	/**
	 * Adds the item to this stack.
	 * 
	 * @param item
	 *            the item to add
	 */
	public void push(Item item) {
		Node<Item> oldfirst = top;
		top = new Node<Item>();
		top.item = item;
		top.next = oldfirst;
		size++;
	}

	/**
	 * Removes and returns the item most recently added to this stack.
	 * 
	 * @return the item most recently added
	 * @throws java.util.NoSuchElementException
	 *             if this stack is empty
	 */
	public Item pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Item item = top.item; // save item to return
		top = top.next; // delete first node
		size--;
		return item; // return the saved item
	}

	/**
	 * Returns (but does not remove) the item most recently added to this stack.
	 * 
	 * @return the item most recently added to this stack
	 * @throws java.util.NoSuchElementException
	 *             if this stack is empty
	 */
	public Item peek() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return top.item;
	}

	/**
	 * Returns a string representation of this stack.
	 * 
	 * @return the sequence of items in the stack in LIFO order, separated by
	 *         spaces
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item : this)
			s.append(item + " ");
		return s.toString();
	}

	/**
	 * Returns an iterator to this stack that iterates through the items in LIFO
	 * order.
	 * 
	 * @return an iterator to this stack that iterates through the items in LIFO
	 *         order.
	 */
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(top);
	}

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	/**
	 * Unit tests the <tt>Stack</tt> data type.
	 */
	public static void main(String[] args) {
		LinkedStack<String> s = new LinkedStack<String>();
		s.push("1");
		s.push("2");
		s.push("4");
		System.out.println(s);
		System.out.println("peek: " + s.peek());
		System.out.println(s);
		System.out.println("pop: " + s.pop());
		System.out.println(s);
	}
}
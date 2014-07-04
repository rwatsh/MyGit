package datastruct;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class StackArray<E> {
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];

	public StackArray() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	public void push(E e) {
		if (size == elements.length) {
			ensureCapa();
		}
		elements[size++] = e;
	}

	@SuppressWarnings("unchecked")
	public E pop() {
		E e = (E) elements[--size];
		elements[size] = null;
		return e;
	}

	private void ensureCapa() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}

	@Test
	public void testStack() {
		StackArray<Integer> stack = new StackArray<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(3);
		stack.push(4);
		assertTrue(4 == stack.pop());
		assertTrue(3 == stack.pop());
		assertTrue(3 == stack.pop());
		assertTrue(2 == stack.pop());
		assertTrue(1 == stack.pop());
	}
}

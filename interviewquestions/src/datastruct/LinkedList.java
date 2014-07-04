package datastruct;

/**
 * Singly linked list.
 * 
 * @author Watsh Rajneesh
 * 
 * @param <T>
 */
public class LinkedList<T> {
	/*
	 * Head of the list.
	 */
	Node<T> head;

	/**
	 * A node in the linked list.
	 * 
	 * @param <T>
	 */
	static class Node<T> {
		Node<T> next;
		T data;

		public Node(T val) {
			this.data = val;
			this.next = null;
		}
	}

	/**
	 * Initialize the linked list.
	 */
	public LinkedList() {
		head = null;
	}

	/**
	 * Append a node to the end of the linked list.
	 * 
	 * @param data
	 */
	public void add(T data) {
		if (head == null) {
			head = new Node<T>(data);
		} else {
			// Append to list
			Node<T> tempNode = head;
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}

			tempNode.next = new Node<T>(data);
		}
	}

	/**
	 * Remove the first matching value node from the list.
	 * 
	 * @param data
	 */
	public void remove(T data) {
		Node<T> tempNode = head;
		Node<T> prevNode = null;

		if (tempNode != null) {
			for (; tempNode.next != null; prevNode = tempNode, tempNode = tempNode.next) {
				if (tempNode.data.equals(data)) {
					if (prevNode != null) {
						prevNode.next = tempNode.next;
					} else {
						/*
						 * Removing head
						 */
						head = tempNode.next;
					}
					break;
				}
			}
			if (tempNode.next == null) {
				/*
				 * Removing last element.
				 */
				head = null;
			}
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.print();
		list.remove(1);
		list.print();
		list.remove(2);
		list.print();
		list.remove(2);
		list.print();
		list.remove(2);
		list.print();
	}

	/**
	 * Print the contents of list.
	 * 
	 * @return contents of list.
	 */
	public String print() {
		Node<T> tempNode = head;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (tempNode != null) {
			while (tempNode.next != null) {
				sb.append(tempNode.data + ",");
				tempNode = tempNode.next;
			}
		}
		sb.append((tempNode != null ? tempNode.data : "") + "]");
		System.out.println(sb.toString());
		return sb.toString();
	}
}

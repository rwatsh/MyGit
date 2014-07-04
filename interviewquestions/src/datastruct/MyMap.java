package datastruct;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

class MyEntry<K, V> {
	private final K key;
	private V value;

	public MyEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}

public class MyMap<K, V> {
	private int size;
	private int DEFAULT_CAPACITY = 16;
	@SuppressWarnings("unchecked")
	private MyEntry<K, V>[] values = new MyEntry[DEFAULT_CAPACITY];

	public V get(K key) {
		for (int i = 0; i < size; i++) {
			if (values[i] != null) {
				if (values[i].getKey().equals(key)) {
					return values[i].getValue();
				}
			}
		}
		return null;
	}

	public void put(K key, V value) {
		boolean insert = true;
		for (int i = 0; i < size; i++) {
			if (values[i].getKey().equals(key)) {
				values[i].setValue(value);
				insert = false;
			}
		}
		if (insert) {
			ensureCapa();
			values[size++] = new MyEntry<K, V>(key, value);
		}
	}

	private void ensureCapa() {
		if (size == values.length) {
			int newSize = values.length * 2;
			values = Arrays.copyOf(values, newSize);
		}
	}

	public int size() {
		return size;
	}

	public void remove(K key) {
		for (int i = 0; i < size; i++) {
			if (values[i].getKey().equals(key)) {
				values[i] = null;
				size--;
				condenseArray(i);
			}
		}
	}

	private void condenseArray(int start) {
		for (int i = start; i < size; i++) {
			values[i] = values[i + 1];
		}
	}

	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		for (int i = 0; i < size; i++) {
			set.add(values[i].getKey());
		}
		return set;
	}
	
	@Test
	public void testMap() {
		MyMap<String, Integer> map = new MyMap<String, Integer>();
	    map.put("Lars", 1);
	    map.put("Lars", 2);
	    map.put("Lars", 1);
		assertEquals(map.get("Lars"), Integer.valueOf(1));
	    for (int i = 0; i < 100; i++) {
	      map.put(String.valueOf(i), i);
	    }
	    assertEquals(map.size(), 101);
	    assertEquals(map.get("51"), Integer.valueOf(51));
	}
}

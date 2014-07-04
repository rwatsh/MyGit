package datastruct;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BetterProgrammerTask {

	/**
	 * Task 1
	 */
	public static int getSumOfNumbers(String s) {
		int retVal = 0;
		/*
		 * Please implement this method to return the sum of all integers found
		 * in the parameter String. You can assume that integers are separated
		 * from other parts with one or more spaces (' ' symbol). For example,
		 * s="12 some text 3  7", result: 22 (12+3+7=22)
		 */
		List<Integer> numList = new ArrayList<>();
		String[] inStrs = s.split("\\s");
		for (String str : inStrs) {
			try {
				int num = Integer.parseInt(str);
				numList.add(num);
			} catch (Exception e) {
				// ignore and proceed to next.
			}
		}

		if (!numList.isEmpty()) {
			for (Integer n : numList) {
				retVal += n;
			}
		}
		return retVal;
	}

	/**
	 * Task 2
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public static List<Integer> getPerfectNumbers(int from, int to) {
		/*
		 * Please implement this method to return a list of all perect numbers
		 * in the given range inclusively. A perfect number is defined as a
		 * positive integer which is the sum of its positive divisors not
		 * including the number itself. For example: 6 is a perfect number
		 * because 6 = 1 + 2 + 3 (1, 2, 3 are divisors of 6) 28 is also a
		 * perfect number: 28 = 1 + 2 + 4 + 7 + 14
		 */
		List<Integer> perfectNumList = new ArrayList<Integer>();

		for (int i = from; i <= to; i++) {
			List<Integer> divisorsList = new ArrayList<Integer>();
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					divisorsList.add(j);
				}
			}
			if (!divisorsList.isEmpty()) {
				int sum = 0;
				for (Integer n : divisorsList) {
					sum += n;
				}
				if (sum == i) {
					perfectNumList.add(i);
					System.out.println(i);
				}
			}
		}
		return perfectNumList;
	}

	/**
	 * Task 3
	 * 
	 * 
	 */
	public static interface Node {
		int getValue();

		List<Node> getChildren();
	}

	public static List<Node> traverseTreeInWidth(Node root) {
		/*
		 * Please implement this method to traverse the tree in width and return
		 * a list of all passed nodes.
		 * 
		 * The list should start with the root node, next it should contain all
		 * second-level nodes, then third-level nodes etc.
		 * 
		 * The method shall work optimally with large trees.
		 */
		List<Node> visitedNodesList = new ArrayList<Node>();
		Queue<Node> queue = new PriorityQueue<Node>();

		if (root != null) {
			queue.add(root);
			while (!queue.isEmpty()) {
				Node visitedNode = queue.remove();
				visitedNodesList.add(visitedNode);
				queue.addAll(visitedNode.getChildren());
			}
		}
		return visitedNodesList;
	}

	/**
	 * Task 4
	 * 
	 * @param cents
	 * @return
	 */
	public static int countWaysToProduceGivenAmountOfMoney(int cents) {
		/*
		 * Please implement this method to return the number of different
		 * combinations of US coins (penny: 1c, nickel: 5c, dime: 10c, quarter:
		 * 25c, half-dollar: 50c) which may be used to produce a given amount of
		 * money.
		 * 
		 * For example, 11 cents can be produced with one 10-cent coin and one
		 * 1-cent coin, two 5-cent coins and one 1-cent coin, one 5-cent coin
		 * and six 1-cent coins, or eleven 1-cent coins. So there are four
		 * unique ways to produce 11 cents. Assume that the cents parameter is
		 * always positive.
		 */
		int coins[] = {1,5,10,25,50};
		
		int table[] = new int[cents+1];
		
		for (int i = 0; i < cents + 1; i++) {
			table[i] = 0;
		}
		
		table[0] = 1;
		
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= cents; j++) {
				table[j] += table[j - coins[i]];
			}
		}
		
		return table[cents];
	}

	
}
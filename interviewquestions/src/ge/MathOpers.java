package ge;

/**
 * Implementing arithmetic operations using + operator.
 * 
 * @author Watsh Rajneesh
 * 
 */
public class MathOpers {

	/**
	 * Add numbers a and b.
	 * 
	 * @param a
	 * @param b
	 * @return sum of a and b.
	 */
	public int add(int a, int b) {
		return a + b;
	}

	/**
	 * Subtract b from a.
	 * 
	 * @param a
	 * @param b
	 * @return result of subtracting b from a.
	 */
	public int subtract(int a, int b) {
		return a + this.multiply(-1, b);
	}

	/**
	 * Multiply a and b.
	 * 
	 * @param a
	 * @param b
	 * @return result of multiplying a and b.
	 */
	public int multiply(int a, int b) {
		int bb = 0;
		int origA = a;

		if (b == 0) {
			return 0;
		}

		if (b == 1) {
			return a;
		}

		if (b < 0) {
			bb = b;
			b = Math.abs(b);
		}

		for (int i = 0; i < (b - 1); i++) {
			a += origA;
		}

		if (bb == 0) {
			return a;
		} else {
			return negateNumber(a);
		}
	}

	/**
	 * Utility method to negate a number.
	 * 
	 * @param a
	 * @return
	 */
	private int negateNumber(int a) {
		if (a < 0) {
			return Math.abs(a);
		}
		String s = "-" + a;
		return Integer.parseInt(s);
	}

	/**
	 * Divide a by b.
	 * 
	 * @param a
	 * @param b
	 * @return quotient of division of a by b.
	 */
	public int divide(int a, int b) {
		boolean isNeg = false;
		if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
			isNeg = true;
		}

		a = Math.abs(a);
		b = Math.abs(b);

		if (a < b) {
			return 0;
		} else if (a == b) {
			return isNeg ? -1 : 1;
		} else {
			int quotient = 0;
			int remainder = a;
			do {
				remainder = this.subtract(remainder, b);
				quotient++;
			} while (remainder > b);
			return isNeg ? negateNumber(quotient) : quotient;
		}
	}
}

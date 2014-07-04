package ge;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MathOperParametrizedTest {

	private int a;
	private int b;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	public MathOperParametrizedTest(int a, int b) {
		this.a = a;
		this.b = b;
	}

	// create test data
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { 1, 2 }, { 5, -10 }, { -121, 152 },
				{ 0, 0 } };
		return Arrays.asList(data);
	}

	@Test
	public void testAdd() {
		MathOpers m = new MathOpers();
		int c = m.add(a, b);
		assertEquals(a + b, c);
	}

	@Test
	public void testSub() {
		MathOpers m = new MathOpers();
		int c = m.subtract(a, b);
		assertEquals(a - b, c);
	}

	@Test
	public void testMultiply() {
		MathOpers m = new MathOpers();
		int c = m.multiply(a, b);
		assertEquals(a * b, c);
	}

	@Test
	public void testDivide() {
		MathOpers m = new MathOpers();
		if (b == 0) {
			/*
			 * Divide by zero error is expected.
			 */
			exception.expect(ArithmeticException.class);
		}
		int c = m.divide(a, b);
		assertEquals(a / b, c);
	}
}

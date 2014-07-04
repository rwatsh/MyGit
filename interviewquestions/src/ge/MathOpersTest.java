package ge;

import org.junit.Assert;
import org.junit.Test;

public class MathOpersTest {

	@Test
	public void testAdd() {
		MathOpers m = new MathOpers();
		int a = 2;
		int b = 4;
		int c = m.add(a, b);
		Assert.assertEquals(6, c);
	}

	@Test
	public void testMultiply() {
		MathOpers m = new MathOpers();
		int a = 2;
		int b = 4;
		int c = m.multiply(a, b);
		Assert.assertEquals(8, c);
	}
	
	@Test
	public void testMultiplyNeg() {
		MathOpers m = new MathOpers();
		int a = 2;
		int b = -4;
		int c = m.multiply(a, b);
		Assert.assertEquals(-8, c);
	}
	
	@Test
	public void testSubtract() {
		MathOpers m = new MathOpers();
		int a = 4;
		int b = 2;
		int c = m.subtract(a, b);
		Assert.assertEquals(2, c);
	}
	
	@Test
	public void testSubtractNeg() {
		MathOpers m = new MathOpers();
		int a = 2;
		int b = 4;
		int c = m.subtract(a, b);
		Assert.assertEquals(-2, c);
	}
	
	@Test
	public void testDivide() {
		MathOpers m = new MathOpers();
		int a = 7;
		int b = 2;
		int c = m.divide(a, b);
		Assert.assertEquals(3, c);
	}
	
	@Test
	public void testDivideNeg() {
		MathOpers m = new MathOpers();
		int a = -7;
		int b = 2;
		int c = m.divide(a, b);
		Assert.assertEquals(-3, c);
	}
	
	@Test
	public void testDivideSameNum() {
		MathOpers m = new MathOpers();
		int a = 2;
		int b = 2;
		int c = m.divide(a, b);
		Assert.assertEquals(1, c);
	}

}

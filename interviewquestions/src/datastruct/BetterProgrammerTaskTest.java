package datastruct;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BetterProgrammerTaskTest {

	@Test
	public void testGetSumOfNumbers() {
		int val = BetterProgrammerTask.getSumOfNumbers("-1 some text 3  7");
		Assert.assertEquals(9, val);
	}
	
	@Test
	public void testPerfectNumbers() {
		List<Integer> list = BetterProgrammerTask.getPerfectNumbers(5, 28);
		Assert.assertEquals(2, list.size());
	}

	@Test
	public void testCountWaysToProduceGivenAmountOfMoney() {
		int count = BetterProgrammerTask.countWaysToProduceGivenAmountOfMoney(11);
		Assert.assertEquals(4, count);
	}
}

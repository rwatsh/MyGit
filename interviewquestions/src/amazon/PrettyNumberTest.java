package amazon;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PrettyNumberTest {

	private int num;
	private String expected;

	public PrettyNumberTest(int n, String e) {
		this.num = n;
		this.expected = e;
	}

	// create test data
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { 341, "341B" }, { 34200, "34.2K" },
				{ 5910000, "5.91M" }, { 1000000000, "1G" }, { 54123, "54.1K" } };
		return Arrays.asList(data);
	}

	@Test
	public void test() {
		String actual = PrettyNumber.convertToPrettyNumber(num);
		Assert.assertEquals(expected, actual);
	}

}

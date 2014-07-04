package problemsolving.string;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CompressStringTest {
	String testStr;
	String expectedStr;

	public CompressStringTest(String ts, String es) {
		this.testStr = ts;
		this.expectedStr = es;
	}

	@Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { "aabcccccaaa", "a2b1c5a3" },
				{ "", "" }, { "abbccccccde", "a1b2c6d1e1" }, {"abc","a1b1c1"} });
	}

	@Test
	public void testCompressString() {
		CompressString cs = new CompressString();

		assertEquals(expectedStr, cs.compressString(testStr));
	}
}

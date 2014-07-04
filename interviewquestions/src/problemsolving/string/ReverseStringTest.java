package problemsolving.string;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ReverseStringTest {
	String testStr = "";
	String expectedStr = "";
	

	@Rule
	public ExpectedException exception = ExpectedException.none();

	public ReverseStringTest(String ts, String es) {
		this.testStr = ts;
		this.expectedStr = es;
	}
	
	@Parameters
	public static Iterable<Object[]> data() {
		return Arrays
				.asList(new Object[][] { { "abracadabra0", "0arbadacarba" },
						{ null, null }, { "", "" } });
	}


	@Test
	public void test() {
		if (testStr == null) {
			exception.expect(NullPointerException.class);
		}
		assertEquals(expectedStr, ReverseString.reverseStr(testStr));
	}

}

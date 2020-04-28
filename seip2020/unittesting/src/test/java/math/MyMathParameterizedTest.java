package math;

/**
 * MyMathParameterizedTest purpose is to test MyMath class and allows
 * to run the same test for different values.
 * 
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2020-04-23
 */

import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class MyMathParameterizedTest {

	@Parameter(value = 0)
	public int number;
	@Parameter(value = 1)
	public int result;

	MyMath mm = new MyMath();
	
	//Test functionality for values 0,1,2 and 12.
	@Parameters
	public static Collection<Object[]> data() {

		return Arrays.asList(new Object[][] {{0,1}, {1, 1}, {2, 2}, {12,479001600}});
	}

	@Test
	public void test_factorial() {

		Assert.assertEquals(result, mm.factorial(number));

	}

}
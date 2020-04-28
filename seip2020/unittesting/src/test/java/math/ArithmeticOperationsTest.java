package math;

/**
 * ArrayOperrationsTest purpose is to test ArrayOperrations class.
 * 
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2019-04-26
 */

import org.junit.Test;
import org.junit.rules.ExpectedException;

import org.junit.Assert;
import org.junit.Rule;

import static org.mockito.Mockito.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArithmeticOperationsTest {
	ArithmeticOperations aop = new ArithmeticOperations();

	// Create ArrayOperrations object using the objects that were created above.


	/**
	 * This is test_reverseArray method which tests if the signs of the integers
	 * inside an array are reversed. It uses reverseSign method for each integer by
	 * mocking IntegerOperations class.
	 */

	// Test if positive integers turn into negative.
	@Test(expected=ArithmeticException.class)
	public void test_zero() {
		aop.divide(3.0,0.0);
	}

	// Test if negative integers turn into positive.
	@Test
	public void test_correctness() {
		Assert.assertEquals(5.0, aop.divide(25,5),0);
	}

	// Define an expected exception for cases that throw exception.
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void test_negative() {

		exception.expect(IllegalArgumentException.class);

		aop.multiply(-4,-2);
	}

	@Test
	public void test_multiply() {

		Assert.assertEquals(25, aop.multiply(5,5));
	}

	@Test
	public void test_out_of_bounds() {

		exception.expect(IllegalArgumentException.class);
		aop.multiply(Integer.MAX_VALUE/2,3);
	}
} 

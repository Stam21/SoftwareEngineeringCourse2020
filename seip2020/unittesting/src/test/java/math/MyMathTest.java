package math;

/**
 * MyMathTest purpose is to test MyMath class.
 * 
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2020-04-23
 */

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyMathTest {

	MyMath mm = new MyMath();

	// Test if exception is thrown when factorial method is used and input number is not between 0 and 12.
	@Test(expected=IllegalArgumentException.class)
	public void test_outofbounds() {
		mm.factorial(13);
	}

	// Test if exception is thrown when factorial method is used and input number is not between 0 and 12.
	@Test(expected=IllegalArgumentException.class)
	public void test_negative() {
		mm.factorial(-1);
	}

	// Test the functionality of factorial method , check if the output is correct.
	@Test
	public void test_correctness_factorial() {
		Assert.assertEquals(120, mm.factorial(5));
	}

	// Test the functionality of factorial method , check if the output is correct.
	@Test
	public void test_zero() {
		Assert.assertEquals(1, mm.factorial(0));
	}

	// Test the functionality of isPrime method , check if the output is correct.
	@Test
	public void test_correctness_prime() {
		Assert.assertSame(true, mm.isPrime(13));
	}

	// Test if exception is thrown when isPrime method takes as input number smaller than 2.
	@Test(expected=IllegalArgumentException.class)
	public void test_non_feasible_prime() {
		mm.isPrime(1);
	}

}


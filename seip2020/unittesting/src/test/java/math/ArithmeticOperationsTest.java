package math;

/**
 * ArithmeticOperationsTest purpose is to test ArithmeticOperations class.
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

public class ArithmeticOperationsTest {

	ArithmeticOperations aop = new ArithmeticOperations();


	// Test if division with 0 throws exception.
	@Test(expected=ArithmeticException.class)
	public void test_divide_zero_denominator() {
		aop.divide(3.0,0.0);
	}
	
	// Test if result of the division is correct when numerator is equal to 0.
	@Test
	public void test_divide_zero_numerator() {
		Assert.assertEquals(0.0, aop.divide(0,3),0);
	}

	// Test if the result of the division is correct.
	@Test
	public void test_division_correctness() {
		Assert.assertEquals(5.0, aop.divide(25,5),0);
	}

	// Define an expected exception for cases that throw exception.
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	// Test that multiply with negative throws exception.
	@Test
	public void test_multiply_both_negative() {

		exception.expect(IllegalArgumentException.class);

		aop.multiply(-4,-2);
	}

	// Test that multiply with negative throws exception.
	@Test
	public void test_multiply_x_negative() {

		exception.expect(IllegalArgumentException.class);

		aop.multiply(-4,2);
	}
	
	// Test that multiply with negative throws exception.
	@Test
	public void test_multiply_y_negative() {

		exception.expect(IllegalArgumentException.class);

		aop.multiply(4,-2);
	}
	
	// Test if the result of the multiplication is correct.
	@Test
	public void test_multiply_correctness() {

		Assert.assertEquals(25, aop.multiply(5,5));
	}
	
	// Test that it throws exception when the result of multiplication is greater than the maximum integer.
	@Test
	public void test__multiply_out_of_bounds() {

		exception.expect(IllegalArgumentException.class);
		aop.multiply(Integer.MAX_VALUE/2,3);
	}
	
	// Test that it returns correct result when y is equal to 0.
	@Test
	public void test_multiply_zero_y() {

		Assert.assertEquals(0, aop.multiply(5,0));
	}
} 

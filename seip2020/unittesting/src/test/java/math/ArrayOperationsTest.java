package math;

/**
 * ArrayOperationsTest purpose is to test ArrayOperations class.
 * 
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2020-04-23
 */

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;
import io.FileIO;

public class ArrayOperationsTest {
	ArrayOperations aop = new ArrayOperations(); // Create ArrayOperations object.
	MyMath mm = new MyMath(); // Create MyMath object.
	FileIO fio = new FileIO(); // Create FileIO object.

	// test_findPrimesInFile method tests if all prime numbers are returned.
	@Test
	public void test_findPrimesInFile() {
		MyMath mym = mock(MyMath.class);
		FileIO fiom = mock(FileIO.class);

		when(mym.isPrime(2)).thenReturn(true);
		when(mym.isPrime(4)).thenReturn(false);
		when(mym.isPrime(11)).thenReturn(true);
		when(mym.isPrime(13)).thenReturn(true);
		when(mym.isPrime(23)).thenReturn(true);

		// Input file context
		int[] filecontext = { 2, 4, 11, 13, 23 };

		Path resourceDirectory = Paths.get("src", "test", "resources", "ValidInputNumbers.txt");
		when(fiom.readFile(resourceDirectory.toString())).thenReturn(filecontext);
		// Using a text file with integers from test/resources.
		Assert.assertArrayEquals(new int[] {2, 11, 13, 23}, aop.findPrimesInFile(fio,resourceDirectory.toString(),mm));
	}


	// Define an expected exception for cases that throw exception.
	@Rule
	public ExpectedException exception = ExpectedException.none();

	// test_findPrimesInEmptyFile tests the case when the given file is empty.
	@Test
	public void test_findPrimesInEmptyFile() {

		exception.expect(IllegalArgumentException.class);

		FileIO fiom = mock(FileIO.class);


		Path resourceDirectory = Paths.get("src", "test", "resources", "Empty.txt");
		when(fiom.readFile(resourceDirectory.toString())).thenThrow(IllegalArgumentException.class);
		// Using a text file with integers from test/resources.
		aop.findPrimesInFile(fio,resourceDirectory.toString(),mm);
	}

	// test_FileNotFound tests the case when the given file is not found.
	@Test
	public void test_FileNotFound() {

		exception.expect(IllegalArgumentException.class);
		FileIO fiom = mock(FileIO.class);
		// Using a text file with integers from test/resources.
		Path resourceDirectory = Paths.get("src", "test", "resources", "ValidInputNumbers2.txt");
		when(fiom.readFile(resourceDirectory.toString())).thenThrow(IllegalArgumentException.class);
		aop.findPrimesInFile(fio,resourceDirectory.toString(),mm);
	}

	// testReadFileContainsInvalidEntries tests the case when the given file does not contain only integers.
	@Test
	public void testReadFileContainsInvalidEntries() {
		exception.expect(IllegalArgumentException.class);

		MyMath mym = mock(MyMath.class);
		FileIO fiom = mock(FileIO.class);

		int[] fileContext = new int[] { 4, 11, 0, -3 };

		// Using a text file with integers from test/resources.
		Path resourceDirectory = Paths.get("src", "test", "resources", "InvalidContext.txt");
		when(fiom.readFile(resourceDirectory.toString())).thenReturn(fileContext);
		when(mym.isPrime(4)).thenReturn(false);
		when(mym.isPrime(11)).thenReturn(true);
		when(mym.isPrime(0)).thenThrow(IllegalArgumentException.class);
		when(mym.isPrime(-3)).thenThrow(IllegalArgumentException.class);
		// The input is not only numbers
		aop.findPrimesInFile(fio,resourceDirectory.toString(),mm);
	}
} 

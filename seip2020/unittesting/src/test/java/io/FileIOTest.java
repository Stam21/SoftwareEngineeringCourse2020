package io;

/**
 * FileIOTest purpose is to test FileIO class.
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
import java.io.IOException;
import static org.mockito.Mockito.*;

public class FileIOTest {

	FileIO fio = new FileIO();

	// test_normal method tests if the context of the given file is read.
	@Test
	public void test_normal() {
		int[] fileContext = new int[] { 2, 4, 11, 13, 23 };

		// Using a text file with integers from test/resources.
		Path resourceDirectory = Paths.get("src", "test", "resources", "ValidInputNumbers.txt");
		Assert.assertArrayEquals(fileContext, fio.readFile(resourceDirectory.toString()));// The input is valid integers

	}



	// testReadFileContainsInvalidEntries tests the case where the given file does not only contains integers.

	@Test
	public void testReadFileContainsInvalidEntries() {
		int[] fileContext = new int[] { 4, 11, 0, -3 };

		// Using a text file with integers from test/resources.
		Path resourceDirectory = Paths.get("src", "test", "resources", "InvalidContext.txt");
		// The input is not only numbers
		Assert.assertArrayEquals(fileContext, fio.readFile(resourceDirectory.toString()));
	}

	// Define an expected exception for cases that throw exception.
	@Rule
	public ExpectedException exception = ExpectedException.none();

	// test_FileNotFound method tests the case where the given file does not exist.
	@Test
	public void test_FileNotFound() {

		exception.expect(IllegalArgumentException.class);

		// Using a text file with integers from test/resources.
		Path resourceDirectory = Paths.get("src", "test", "resources", "ValidInputNumbers2.txt");
		fio.readFile(resourceDirectory.toString());
	}

	// test_FileisEmpty method tests the case where the given file is empty.
	@Test
	public void test_FileisEmpty() {

		exception.expect(IllegalArgumentException.class);

		// Using a text file with integers from test/resources.
		Path resourceDirectory = Paths.get("src", "test", "resources", "Empty.txt");
		fio.readFile(resourceDirectory.toString());
	}
	


}

package math;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import io.FileIO;

/**
 * The ArrayOperations performs operations on arrays,
 * that serve as hands-on practice on Unit Testing.
 * 
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2020-04-23
 */
public class ArrayOperations{
	
	/**
	 * Method that search a file and return all the prime numbers found.
	 * @param fileIO object to use readFile method
	 * @param filepath to define the file that should be read
	 * @param mymath object to check which numbers are prime
	 * @return an array with all the prime numbers found in the file.
	 */
	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		List<Integer> primeList = new ArrayList<>();
		int[] numbers = fileIo.readFile(filepath);
		for (int i : numbers){
			if (myMath.isPrime(i)) {
				primeList.add(i);
			}
		}
		
		// Convert a List to an array 
		return primeList.stream().mapToInt(i -> i).toArray();
	}
}
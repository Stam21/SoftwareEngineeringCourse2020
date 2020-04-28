package math;

/**
 * The MyMath performs mathematical operations to calculate factorial or check if a number is prime,
 * that serve as hands-on practice on Unit Testing.
 * 
 * @author George Stamatopoulos
 * @version 1.0
 * @since 2020-04-23
 */
public class MyMath {
	
	/**
	 * Method that calculates and returns the factorial of a given number n.
	 * @param n number for which we calculate the factorial
	 * @return the factorial of input number n 
	 * @exception IllegalArgumentException when n is not between 0 and 12 
	 */
	public int factorial(int n) {
		int fact = 1;
		if (n==0 || n==1){
			return fact;
		}else if (n>1 && n<=12){
			for (int i=n; i>1; i--){
				fact *= i;
			}
			return fact;
		}else {
			throw new IllegalArgumentException("There is no factorial for negative number and we do not need n! for n>12");		
		}	
	}

	/**
	 * Method that checks and returns if a given number n is prime.
	 * @param the number that will be checked if it is prime or not 
	 * @return boolean whether the number is prime or not
	 * @exception IllegalArgumentException when n is not between 0 and 12 
	 */
	public boolean isPrime(int n) {
		int counter=0;
		if (n>=2) {
			for (int i=1; i<=n;i++) {
				if((n%i)==0) {
					counter++;
				} 				
			}
			if (counter==2) {
				return true;
			}else {
				return false;
			}
		}else {
			throw new IllegalArgumentException("Can't return prime number for n<2");
		}	
	}
	
}
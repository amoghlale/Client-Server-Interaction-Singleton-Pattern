package primeService.util;

/**
 * CheckPrime--- 	Checks whether number is prime or not. 
 * 					Also, if value is less than threshold 
 * 					value then, "Not valid" should be 
 * 					displayed. 
 * @author    		Amogh Lale
 */
public class CheckPrime {
	Debug deb=Debug.getInstance();
	/**
	   * Default Constructor of CheckPrime Class 
	   * @param No arguments
	   * @exception No exception
	   * @return No return value.
	   */
	public CheckPrime(){
		deb.printToStdout(1, "Constructor of CheckPrime class is called");
	}
	
	/**
	   * Verify whether a number is prime or not. 
	   * @param number from client
	   * @exception No exception
	   * @return status of the number.
	   */
	public String checknum(int num){
	 deb.printToStdout(2, "checknum() of CheckPrime class is called");	
	 final int  THRESHOLD=3; 
	 
	 if(num%2==0)
		return "Not Prime";
	 else if(num<=THRESHOLD)
		return "Not Valid";
	 return "Prime";
	 }
	
	/**
	 * Default toString() method of CheckPrime Class. 
	 * @param No arguments
	 * @exception No exception
	 * @return No Return Value.
	 */
	public String toString() {
		deb.printToStdout(2, "toString() method of CheckPrime class is called");
		String retValue = "\n toString() method of CheckPrime \n";
		return retValue;
    }
	
}


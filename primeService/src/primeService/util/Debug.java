package primeService.util;


/**
 * Debug --- 	Matches the Debug Value given in the command line 
 * 			 	argument with the level. If it matches, then only 
 * 				those debug messages corresponding to the given 
 * 				level would be displayed on stdout.
 * @author    	Amogh Lale
 */
public class Debug {
	
	private static int DEBUG_VALUE; // static debug value obtained 
								   // from command line 
	private static Debug uniqueInstance = new Debug();
	Debug deb=Debug.getInstance();
	/**
	   * Private Constructor of Debug Class 
	   * @param No arguments
	   * @exception No exception
	   * @return No return value.
	   */
	private Debug() { }
	
	/**
	   * getinstance() method to return unique instance 
	   * @param No arguments
	   * @exception No exception
	   * @return No return value.
	   */
	public static Debug getInstance() {

		return uniqueInstance;

	}
	
	/**
	   * SetValue method is used to validate whether args[3]
	   * is between 1 and 3.This value is then stored in DEBUG_VALUE 
	   * @param args[3]
	   * @exception No exception
	   * @return No return value.
	   */
	public static void setValue(String args){
	if (!(args.equals("1")||args.equals("2")||args.equals("3")))
	{
        System.err.println("\nInvalid command line argument");	
		System.exit(0);
	}
	DEBUG_VALUE=Integer.parseInt(args);
	}
	
	/**
	   * getValue method is used to return DEBUG_VALUE. This value 
	   * is compared with level so as to display correct output on
	   * stdout. 
	   * @param no arguments
	   * @exception No exception
	   * @return DEBUG_VALUE
	   */
	public static int getValue(){
		return DEBUG_VALUE;
	}
	
	/**
	   * Displays the debug messages corresponding to the debug value
	   * given in the command line arguments.  
	   * @param level to match with command line argument and 
	   * debug message corresponding to the level given.
	   * @exception No exception
	   * @return No return value.
	   */
	 public void printToStdout(int level, String debugMessage){

		 if(level==getValue()){
		 System.out.println(debugMessage);
		 
	  } //end if condition
	 }
	 
	 /**
	   * Default toString() method of Debug Class. 
	   * @param No arguments
	   * @exception No exception
	   * @return returns the string in retVal.
	   */
	 public String toString() {
		 deb.printToStdout(2, "toString() method of Debug class is called");
			String retValue = "\n toString() method of Debug Class \n";
			return retValue;
		    }
}

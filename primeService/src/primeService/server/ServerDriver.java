package primeService.server;


import primeService.socket.PrimeServerSocket;
import primeService.util.Debug;

/**
 * ServerDriver--- 	Creates Server Socket and calls 
 * 					server menu.
 * @author    		Amogh Lale
 */
public class ServerDriver {
	
	Debug deb=Debug.getInstance();
	/**
	   * Default Constructor of ServerDriver Class 
	   * @param No arguments
	   * @exception No exception
	   * @return No return value.
	   */	
	public ServerDriver(){
		deb.printToStdout(1, "Constructor of ServerDriver class is called");
	}
	
	/**
	   * Creates a new PrimeServerSocket Thread and starts 
	   * the thread.It also displays the server menu.  
	   * @param portnumber
	   * @exception No exception
	   * @return No return value.
	   */
	public void createServerSocket(String port) {
		deb.printToStdout(2, "createServerSocket() of ServerDriver class is called");
    	PrimeServerSocket ps=null;
    	ps=new PrimeServerSocket(port);
     	Thread t=new Thread(ps);
    	t.start();
        
    	ServerMenuInterface sm=new ServerMenu();
		sm.displayServerMenu();
    }
	
	/**
	 * Default toString() method of ServerDriver Class. 
	 * @param No arguments
	 * @exception No exception
	 * @return returns the string in retVal.
	 */
	public String toString() {
		deb.printToStdout(2, "toString() method of ServerDriver class is called");
		String retValue = "\n toString() method of ServerDriver \n";
		return retValue;
    }
}

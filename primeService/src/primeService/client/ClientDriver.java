package primeService.client;

import primeService.socket.PrimeClientSocket;
import primeService.util.Debug;

/**
 * ClientDriver--- 	Creates Client Socket.
 * @author    		Amogh Lale
 */

public class ClientDriver {

	Debug deb=Debug.getInstance();
	/**
	   * Default Constructor of ClientDriver Class 
	   * @param No arguments
	   * @exception No exception
	   * @return No return value.
	   */	
		public ClientDriver(){
			deb.printToStdout(1, "Constructor of ClientDriver is called");
		}

		
	/**
	   * Create Client Socket using the port number and host name 
	   * sent by PrimeDriver. 
	   * @param portnumber and host name
	   * @exception No exception
	   * @return No return value.
	   */	
		public void createClientSocket(String port, String hostname) {
			deb.printToStdout(2, "createClientSocket() of ClientDriver is called");
			PrimeClientSocket ps2=new PrimeClientSocket();	
			ps2.creatClientSock(port,hostname);
		}


		/**
		 * Default toString() method of ClientDriver Class. 
		 * @param No arguments
		 * @exception No exception
		 * @return returns the string in retVal.
		 */
		public String toString() {
			deb.printToStdout(2, "toString() method of ClientDriver class is called");
			String retValue = "\n toString() method of ClientDriver \n";
			return retValue;
	    }
}




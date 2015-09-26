package primeService.socket;


import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import primeService.client.ClientMenu;
import primeService.client.ClientMenuInterface;
import primeService.util.Debug;

/**
 * PrimeClientSocket--- 	Creates a new client Socket and  
 * 							calls ClientMenu using an object of 
 * 							PrimeClientWorker. 
 * @author    				Amogh Lale
 */

public class PrimeClientSocket {
   
	public String clientname;
	public Integer num;
	PrimeClientWorker pc=null;
	Socket clientSocket=null ;
	Debug deb=Debug.getInstance();
   /**
	   * Default Constructor of PrimeClientSocket Class 
	   * @param No arguments
	   * @exception No exception
	   * @return No return value.
	   */	
	public PrimeClientSocket(){
		deb.printToStdout(1, "Constructor of PrimeClientSocket class is called");
	}
   
	/**
	   * Creates client socket and call ClientMenu. 
	   * @param Port number and host name from Client 
	   * 		Driver.
	   * @exception IOException and UnknownHostException
	   * @return No return value.
	   */	
	public void creatClientSock(String port, String hostname) {
		    
	     System.out.println("Client driver started");
	     deb.printToStdout(2, "creatClientSock() of PrimeClientSocket class is called");
			try {
				int portnum=Integer.parseInt(port);
				this.clientSocket = new Socket(hostname, portnum);
			} catch (UnknownHostException e) {
				System.err.println("Unknown host error");
				System.exit(0);
			} catch (IOException e) {
				System.err.println("IO exception host error");
				System.exit(0);
			}
			
			pc=new PrimeClientWorker(clientSocket);
			ClientMenuInterface cm=new ClientMenu();
			cm.displayClientMenu(pc);
			
			
	}
	
	/**
	 * Default toString() method of PrimeClientSocket Class. 
	 * @param No arguments
	 * @exception No exception
	 * @return returns the string in retVal.
	 */
	public String toString() {
		deb.printToStdout(2, "toString() method of PrimeClientSocket class is called");
		String retValue = "\n toString() method of PrimeClientSocket \n";
		return retValue;
    }
 }

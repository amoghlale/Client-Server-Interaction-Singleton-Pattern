package primeService.socket;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import primeService.util.Debug;

/**
 * PrimeServerSocket--- 	Creates a server socket using port 
 * 							number and passes the socket to the 
 * 							thread of PrimeServerWorker. 
 * @author    				Amogh Lale
 */
public class PrimeServerSocket implements Runnable {
	ServerSocket ssocket = null;
	Socket socket=null;
	public String port;
	Debug deb=Debug.getInstance();
	/**
	   * Parametrized Constructor of PrimeServerSocket Class 
	   * @param port number
	   * @exception IOException
	   * @return No return value.
	   */
	public PrimeServerSocket(String port){
		deb.printToStdout(1, "Constructor of PrimeServerSocket class is called");
		this.port=port;
	}
		
	/**
	   * Creates a new server socket. It waits for accepting 
	   * a connection from client. Many clients can be connected 
	   * to 1 server.It also starts a PrimeServerWorker Thread  
	   * @param No Arguments
	   * @exception IOException
	   * @return No return value.
	   */
	public void run() {
		deb.printToStdout(2, "run() of PrimeServerSocket class is called");
		 try {
		    	int portnumber=Integer.parseInt(port);
				ssocket = new ServerSocket(portnumber);
			} catch (IOException e1) {
				System.err.println("IOException error while creating serversocket");
				System.exit(0);
			}
		 try{
		 while(true)
		 {
			 	socket = ssocket.accept(); 
				PrimeServerWorker sw = new PrimeServerWorker(socket); 
				Thread t=new Thread(sw);
				t.start();
			
		 } 
		} catch(IOException ioe) { 
			System.err.println("IO Exception occured while accepting connection ");
			System.exit(0);
		}
		
	}
	
	/**
	 * Default toString() method of PrimeServerSocket Class. 
	 * @param No arguments
	 * @exception No exception
	 * @return returns the string in retVal.
	 */
	public String toString() {
		deb.printToStdout(2, "toString() method of PrimeServerSocket class is called");
		String retValue = "\n toString() method of PrimeServerSocket \n";
		return retValue;
    }
}


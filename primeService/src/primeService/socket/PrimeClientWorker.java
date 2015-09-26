package primeService.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import primeService.util.Debug;

/**
 * PrimeClientWorker--- 	Handles interaction with server.
 * 							It involves sending and receiving 
 * 							responses.  
 * @author    				Amogh Lale
 */
public class PrimeClientWorker {

	public Socket client;
	private String clientname;
	private Integer num;
    String responseFromServer = null;
    Debug deb=Debug.getInstance();
    /**
	   * Parametrized Constructor of PrimeClientWorker Class 
	   * @param socket
	   * @exception No exception
	   * @return No return value.
	   */	
    public PrimeClientWorker(Socket socket) {
    	deb.printToStdout(1, "Constructor of PrimeClientWorker class is called");
		this.client=socket;
	}
	
    /**
	   * Send and receives responses from PrimeServerWorker Class 
	   * @param name of the client and prime number
	   * @exception IOException
	   * @return No return value.
	   */
	public void connectToServer(String clientname,Integer num) {
		deb.printToStdout(2, "connectToServer() of PrimeClientWorker class is called");
	   	try {
			PrintWriter outToServer = new PrintWriter(client.getOutputStream(), true);
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
		    outToServer.println(clientname + ","+ num);
		    outToServer.flush();
			responseFromServer = inFromServer.readLine();
			DisplayResponseToMenu();
				
		} catch (IOException e1) {
			System.err.println("IO exception error in PrimeClientWorker");
			System.exit(0);
		}
	}

	/**
	   * Displays response from server. If server terminated
	   * or if response is null then no response from server 
	   * is displayed. 
	   * @param No arguments
	   * @exception No exception
	   * @return Server Response.
	   */
	public String DisplayResponseToMenu() {
		deb.printToStdout(2, "DisplayResponseToMenu() of PrimeClientWorker class is called");
		if(responseFromServer==null)
		{	
			responseFromServer="No Response from server";
			System.exit(0);
		
		}	
		return responseFromServer;
	}

	/**
	   * Get the values from Client Menu. 
	   * @param Client Name and user number
	   * @exception No exception
	   * @return No Return Value.
	   */
	public void getValues(String cname, int usernumber) {
		deb.printToStdout(2, "getValues() of PrimeClientWorker class is called");
		clientname=cname;
		num=usernumber;
		connectToServer(clientname, num);
	}
	

	/**
	 * Default toString() method of PrimeClientWorker Class. 
	 * @param No arguments
	 * @exception No exception
	 * @return No Return Value.
	 */
	public String toString() {
		deb.printToStdout(2, "toString() method of PrimeClientWorker class is called");
		String retValue = "\n toString() method of PrimeClientWorker \n";
		return retValue;
    }
}

package primeService.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import primeService.server.AllPrimeQueries;
import primeService.util.CheckPrime;
import primeService.util.Debug;

/**
 * PrimeServerWorker--- 	Interacts with PrimeClientWorker and 
 * 							handles multiple clients. 
 * @author    				Amogh Lale
 */
public class PrimeServerWorker implements Runnable {
	Socket socket=null;
	String clientname,int_val;
 	int desired_value;
 	BufferedReader in = null;
    PrintWriter out = null;
    String inFromClient=null;
    String delims = "[,]";
    String[] tokens=null;
    Debug deb=Debug.getInstance();
    /**
	   * Parametrized Constructor of PrimeServerWorker Class 
	   * @param socket
	   * @exception No exception
	   * @return No return value.
	   */	
	public PrimeServerWorker(Socket socket){
		deb.printToStdout(1, "Constructor of PrimeServerWorker class is called");
		this.socket=socket;
	}
	
	 /**
	   *  It send the entry to AllPrimeQueries to be added 
	   *  to Data Structure.It also sends the 
	   *  number obtained from client, to CheckPrime class, 
	   *  to check for prime. It gets the response from 
	   *  checkPrime and sends it back to PrimeCLientWorker.
	   *  @param No Arguments
	   *  @exception IOException
	   *  @return No return value.
	   */	
	public void run() {
		deb.printToStdout(2, "run() of PrimeServerWorker class is called");
		AllPrimeQueries ap=AllPrimeQueries.getInstance();
		 	try{
			      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			      out = new PrintWriter(socket.getOutputStream(), true);
			    } catch (IOException e) {
			      System.err.println("IOException error in BufferedReader/PrintWriter");
			      System.exit(0);
			    }
		 	
		    while(true){
		    	 try{
		    	   		inFromClient=in.readLine();
		    	   		tokens = inFromClient.split(delims);  
		    	   		clientname = tokens[0];
		    	   		int_val=tokens[1];
		    	   		desired_value=Integer.parseInt(int_val);
	    	  
		    	   		ap.addEntry(clientname, desired_value);
		    	   		CheckPrime cp=new CheckPrime();
		    	   		String response=cp.checknum(desired_value);
		    	   		out.println("< primeQueryResponse>< intValue>"+int_val+"< /intValue>< isPrime>"+response+"< /isPrime>< /primeQueryResponse>");
		    	
		    	}catch (IOException e) {
		       	System.err.println("Read failed in PrimeServerWorker");
		        System.exit(0);
		       }
			  
		    } //while loop ends
	} // run() ends
	
	/**
	 * Default toString() method of PrimeServerWorker Class. 
	 * @param No arguments
	 * @exception No exception
	 * @return No Return Value.
	 */
	public String toString() {
		deb.printToStdout(2, "toString() method of PrimeServerWorker class is called");
		String retValue = "\n toString() method of PrimeServerWorker \n";
		return retValue;
    }
}
      


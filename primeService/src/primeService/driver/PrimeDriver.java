package primeService.driver;


import primeService.client.ClientDriver;
import primeService.server.ServerDriver;
import primeService.util.Debug;

/**
 * PrimeDriver --- 	Driver code.
 * @author    	    Amogh Lale
 */
public class PrimeDriver {

public static void main(String[] args) {

String choice=args[0];

if (choice.equalsIgnoreCase("server"))
	{
		String port=args[1];
		Debug.setValue(args[2]);
		ServerDriver sd=new ServerDriver();
		sd.createServerSocket(port);
		
	}
	
	else if(choice.equalsIgnoreCase("client"))
	{
		String hostname=args[1];
		String port=args[2];
		Debug.setValue(args[3]);
		ClientDriver cd=new ClientDriver();
		cd.createClientSocket(port,hostname);
		
	}
	else
	{
		System.out.println("Enter valid options");
		System.exit(0);
	}	


}

}

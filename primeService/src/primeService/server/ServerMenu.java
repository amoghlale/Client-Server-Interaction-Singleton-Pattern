package primeService.server;

import java.util.Scanner;

import primeService.util.Debug;



/**
 * ServerMenu---	Displays Server Menu. 
 * 					server menu.
 * @author    		Amogh Lale
 */
public class ServerMenu implements ServerMenuInterface{
	Debug deb=Debug.getInstance();
	/**
	   * Default Constructor of ServerMenu Class 
	   * @param No arguments
	   * @exception No exception
	   * @return No return value.
	   */	
	public ServerMenu(){
		deb.printToStdout(1, "Constructor of ServerMenu class is called");
	}
	
	/**
	   * Display Server Menu and ask for user inputs. 
	   * @param No Arguments
	   * @exception No exception
	   * @return No return value.
	   */	
	public void displayServerMenu(){
		int server_choice;
		Scanner sc=new Scanner(System.in);
		
		AllPrimeQueries apq=AllPrimeQueries.getInstance();
		deb.printToStdout(3, "displayServerMenu() of ServerMenu class is called");
		do{
			
		System.out.println("1.Client Name ");
		System.out.println("2.All Client Queries ");
		System.out.println("3.Quit ");
		server_choice=sc.nextInt();
		switch(server_choice)
		{
		case 1: String client_name=sc.next();
				apq.displayClientEntry(client_name);
				break;
		
		case 2: apq.display();
				break;		
		
		case 3: System.exit(0);
				break;
		
		default:System.out.println("Invalid option entered by user");
				break;
		}
	}while (server_choice!=3);
	sc.close();
			
	}
	 
}

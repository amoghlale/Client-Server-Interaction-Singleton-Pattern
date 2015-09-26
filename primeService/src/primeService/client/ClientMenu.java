package primeService.client;

import java.util.Scanner;


import primeService.socket.PrimeClientWorker;
import primeService.util.Debug;

/**
 * ClientMenu--- 	Displays Client Menu.
 * @author    		Amogh Lale
 */

public class ClientMenu implements ClientMenuInterface{
	
	String serverResponse=null;
	PrimeClientWorker menuCwr=null;
	Debug deb=Debug.getInstance();
	/**
	   * Default Constructor of ClientMenu Class 
	   * @param No arguments
	   * @exception No exception
	   * @return No return value.
	   */	
	public ClientMenu(){
		deb.printToStdout(1, "Constructor of ClientMenu is called");
	}
	
	/**
	   * Display Client Menu and ask for user inputs. 
	   * @param Object of PrimeClientWorker class
	   * @exception No exception
	   * @return No return value.
	   */	
	public void displayClientMenu(PrimeClientWorker cwr) {
		menuCwr=cwr;
		Scanner sc=new Scanner(System.in);
		int client_choice;
		int usernumber;
		String cname=null;
		deb.printToStdout(3, "displayClientMenu() of ClientMenu is called");
		do {
			System.out.println("1.Set client name ");
			System.out.println("2.Enter number to query for prime ");
			System.out.println("3.What is the server response? ");
			System.out.println("4.Quit");
			client_choice=sc.nextInt();
			switch (client_choice) {
		
			case 1:
					cname=sc.next();
					break;
			case 2:
					System.out.println("Last client name entered: "+cname);
					usernumber=sc.nextInt();
					menuCwr.getValues(cname, usernumber);	
					break;
					
			case 3: serverResponse=menuCwr.DisplayResponseToMenu();
					System.out.println(serverResponse);
					break;
				   
			case 4: System.exit(0);
					break;
			default:
					System.out.println("Invalid options");
					break;
			}
				
		} while (client_choice!=4);
		
		sc.close();
		
	}
	
	/**
	 * Default toString() method of ClientMenu Class. 
	 * @param No arguments
	 * @exception No exception
	 * @return returns the string in retVal.
	 */
	public String toString() {
		deb.printToStdout(2, "toString() method of ClientMenu class is called");
		String retValue = "\n toString() method of ClientMenu \n";
		return retValue;
    }

	
}

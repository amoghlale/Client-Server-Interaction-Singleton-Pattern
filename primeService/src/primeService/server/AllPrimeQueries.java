package primeService.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import primeService.util.Debug;



/**
 * AllPrimeQueries--- 	Singleton pattern is followed by this class.
 * 						Entries from client are added to Data 
 * 						Structure.It also displays selected
 * 						client entries or all client entries.
 * @author    			Amogh Lale
 */
public class AllPrimeQueries{

	
	private static AllPrimeQueries uniqueInstance = new AllPrimeQueries();
	Debug deb=Debug.getInstance();
	/**
	   * Private Constructor of AllPrimeQueries Class 
	   * @param No arguments
	   * @exception No exception
	   * @return No return value.
	   */	
	private AllPrimeQueries() { }

	/**
	   * getinstance() method to return unique instance 
	   * @param No arguments
	   * @exception No exception
	   * @return No return value.
	   */
	public static AllPrimeQueries getInstance() {

		return uniqueInstance;

}
	ConcurrentMap<String, List<Integer>> map = new ConcurrentHashMap<String, List<Integer>>();

	/**
	   * Adds entry to data structure. I have used 
	   * Concurrent Hashmap because it is thread safe. 
	   * Also, 1 key can have multiple values associated
	   * with it. Hence I am using Arraylist.  
	   * @param client name and number entered by client
	   * @exception No exception
	   * @return No return value.
	   */
	
	public void addEntry(String name, Integer number){
		deb.printToStdout(2, "addEntry() method of AllPrimeQueries class is called");
		if (map.containsKey(name) ) 
		{ 
		        map.get(name).add(number);
		}
		else 
		{
		        List<Integer> list = new ArrayList<Integer>();
		        list.add(number);
		        map.put(name, list);
		}	 
			
	}	
	
	/**
	   * Displays all client entries in the data structure
	   * @param No Arguments
	   * @exception No exception
	   * @return No return value.
	   */
	public void display(){
	for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
		deb.printToStdout(2, "display() method of AllPrimeQueries class is called");
		String key = entry.getKey();
		List<Integer> values = entry.getValue();
		System.out.println("Client Name : " + key);
		System.out.println("Values : " + values);
		}
	}
	
	/**
	   * Displays selected client's values.
	   * @param Desired client name
	   * @exception No exception
	   * @return No return value.
	   */
	public void displayClientEntry(String client_name) {
		deb.printToStdout(2, "displayClientEntry() method of AllPrimeQueries class is called");
		if (map.containsKey(client_name) ) { 
	        System.out.println("Client name found "+map.get(client_name));
	     }
		else
			System.out.println("No data for given client name");
			
	}

	/**
	 * Default toString() method of AllPrimeQueries Class. 
	 * @param No arguments
	 * @exception No exception
	 * @return returns the string in retVal.
	 */
	public String toString() {
		deb.printToStdout(2, "toString() method of AllPrimeQueries class is called");
		String retValue = "\n toString() method of AllPrimeQueries \n";
		return retValue;
    }

}

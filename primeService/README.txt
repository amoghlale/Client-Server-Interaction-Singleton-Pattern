CS542 Design Patterns
Spring 2015
PROJECT <2> README FILE

Due Date: <Monday, March 9, 2015>
Submission Date: <Monday, March 9, 2015>
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <Lale Amogh Pramod> 
e-mail(s): <alale1@binghamton.edu> 

PURPOSE:
[
  My assignment tries to capture all client side actions into a 
  concurrent hashmap. Using the menu on the client side. The data 
  structure contents can be shown using a menu on server side. I 
  used concurrent hashmap because, it is thread-safe, which is a 
  requirement of the assignment.I have made my AllPrimeQueries class as singleton for synchronized access.
]

PERCENT COMPLETE:
[
  I believe I have completed 100% of this assignment. My judgement is based 
on the fact that all client actions can be captured in the data structure and 
displayed  on server. Multiple values can be assigned to one key in the data structure
used.When server exits, all clients shut down.
]

PARTS THAT ARE NOT COMPLETE:
[
  I believe everything is complete.
]

BUGS:

[
  None
]

FILES:

[

Included with this project are 12 class files:
Class files-
PrimeDriver.java the main file associated with the program also contains main
ServerDriver.java the server socket thread is created and server menu method is called in this file
ClientDriver.java the server socket is created in this file
ServerMenu.java the file to display server menu and interact with data structure to retrieve values
ClientMenu.java the file to display client menu and interact with PrimeClientWorker.java to capture and display user responses.
Debug.java the file to validate command line arguments and print to standard output method
CheckPrime.java the file to check if number is prime or not
AllPrimeQueries.java the file consisting operations to add data entries to data structure and display them
PrimeServerSocket.java the file where socket is created and PrimeServerWorker thread is started
PrimeServerWorker.java the file concerned with receiving client side input and sending back responses.
PrimeClientSocket.java the file where socket is created and Client Menu is displayed
PrimeClientWorker.java the file concerned with sending user inputs to server side and getting back responses.

README.txt the text file you are presently reading
]

SAMPLE OUTPUT:

[

server-
amogh@ubuntu:~/Documents/eclipse_workspace/primeService$ ant -buildfile src/build.xml run
Buildfile: src/build.xml

jar:
    [mkdir] Created dir: /home/amogh/Documents/eclipse_workspace/primeService/BUILD/jar
      [jar] Building jar: /home/amogh/Documents/eclipse_workspace/primeService/BUILD/jar/primeService.jar

run:
     [java] createServerSocket() of ServerDriver class is called
     [java] run() of PrimeServerSocket class is called
     [java] displayServerMenu() of ServerMenu class is called
     [java] 1.Client Name 
     [java] 2.All Client Queries 
     [java] 3.Quit 
     [java] run() of PrimeServerWorker class is called
     [java] addEntry() method of AllPrimeQueries class is called
     [java] checknum() of CheckPrime class is called
1
amogh
     [java] displayClientEntry() method of AllPrimeQueries class is called
     [java] Client name found [24]
     [java] 1.Client Name 
     [java] 2.All Client Queries 
     [java] 3.Quit 
     [java] run() of PrimeServerWorker class is called
     [java] addEntry() method of AllPrimeQueries class is called
     [java] checknum() of CheckPrime class is called
1
amogh
     [java] displayClientEntry() method of AllPrimeQueries class is called
     [java] Client name found [24, 36]
     [java] 1.Client Name 
     [java] 2.All Client Queries 
     [java] 3.Quit 
2
     [java] display() method of AllPrimeQueries class is called
     [java] Client Name : amogh
     [java] Values : [24, 36]
     [java] 1.Client Name 
     [java] 2.All Client Queries 
     [java] 3.Quit 


Client 1 side:
amogh@ubuntu:~/Documents/eclipse_workspace/primeService$ ant -buildfile src/build.xml run
Buildfile: src/build.xml

jar:
    [mkdir] Created dir: /home/amogh/Documents/eclipse_workspace/primeService/BUILD/jar
      [jar] Building jar: /home/amogh/Documents/eclipse_workspace/primeService/BUILD/jar/primeService.jar

run:
     [java] createClientSocket() of ClientDriver is called
     [java] Client driver started
     [java] creatClientSock() of PrimeClientSocket class is called
     [java] displayClientMenu() of ClientMenu is called
     [java] 1.Set client name 
     [java] 2.Enter number to query for prime 
     [java] 3.What is the server response? 
     [java] 4.Quit
1
amogh
     [java] 1.Set client name 
     [java] 2.Enter number to query for prime 
     [java] 3.What is the server response? 
     [java] 4.Quit
2
     [java] Last client name entered: amogh
24
     [java] getValues() of PrimeClientWorker class is called
     [java] connectToServer() of PrimeClientWorker class is called
     [java] DisplayResponseToMenu() of PrimeClientWorker class is called
     [java] 1.Set client name 
     [java] 2.Enter number to query for prime 
     [java] 3.What is the server response? 
     [java] 4.Quit
4

Client 2 side-
amogh@ubuntu:~/Documents/eclipse_workspace/primeService$ ant -buildfile src/build.xml run
Buildfile: src/build.xml

jar:
    [mkdir] Created dir: /home/amogh/Documents/eclipse_workspace/primeService/BUILD/jar
      [jar] Building jar: /home/amogh/Documents/eclipse_workspace/primeService/BUILD/jar/primeService.jar

run:
     [java] createClientSocket() of ClientDriver is called
     [java] Client driver started
     [java] creatClientSock() of PrimeClientSocket class is called
     [java] displayClientMenu() of ClientMenu is called
     [java] 1.Set client name 
     [java] 2.Enter number to query for prime 
     [java] 3.What is the server response? 
     [java] 4.Quit
1
amogh
     [java] 1.Set client name 
     [java] 2.Enter number to query for prime 
     [java] 3.What is the server response? 
     [java] 4.Quit
2
     [java] Last client name entered: amogh
36
     [java] getValues() of PrimeClientWorker class is called
     [java] connectToServer() of PrimeClientWorker class is called
     [java] DisplayResponseToMenu() of PrimeClientWorker class is called
     [java] 1.Set client name 
     [java] 2.Enter number to query for prime 
     [java] 3.What is the server response? 
     [java] 4.Quit
3
     [java] DisplayResponseToMenu() of PrimeClientWorker class is called
     [java] < primeQueryResponse>< intValue>36< /intValue>< isPrime>Not Prime< /isPrime>< /primeQueryResponse>
     [java] 1.Set client name 
     [java] 2.Enter number to query for prime 
     [java] 3.What is the server response? 
     [java] 4.Quit
4

]

TO COMPILE:

[
  ant -buildfile src/build.xml all
]

TO RUN:

[
  ant -buildfile src/build.xml run
]

EXTRA CREDIT:

[
  Project running successfully on eclipse as well as using ANT. 
  DEBUG_VALUE=1 [Print to stdout everytime a constructor is called] 			
  DEBUG_VALUE=2 [Print to stdout everytime a method other than a constructor is called] 
  if server terminates, client has to enter client name and prime number query. This is because 
  latest server response is displayed by using #3 in client menu.  	
]

BIBLIOGRAPHY:

[

http://stackoverflow.com/questions/2165006/simple-java-client-server-program
http://stackoverflow.com/questions/22663107/print-all-key-value-pairs-in-a-java-concurrenthashmap
http://stackoverflow.com/questions/12358363/how-do-i-store-many-values-with-one-key
http://java.dzone.com/articles/hashmap

]

ACKNOWLEDGEMENT:
[

Prof. Madhusudhan Govindaraju
cs542.cs.binghamton.edu mailing list

]

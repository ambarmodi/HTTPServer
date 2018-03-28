# HTTPServer
Its a simple multi-threaded HTTP Server that only accepts HTTP GET requests and returns the desired content to the client.

### Instructions to execute.
1. make 					(This will compile the program)
2. java Server				(This will start the HTTP server)
3. make clean 				(Optional : This will clean compiled .class files)
4. Ctrl + C 				(To Terminate/kill the server)



### Brief Description:
##### Server.Java 
1. Server.java is the Server class(containing the main function) which creates the socket and listen on the port 8080.
2. The server is responsible to accept the TCP request through socket and creates a new thread to process each Http Request.
3. Server receives the requested resource name, client port number and client IP address.
4. Server also prints the number of time the resource is requested along with above details from the client.

##### HttpHandler.java
1. HttpHandler is responsible to parse the Http GET Request for a requested resource.
2. If the request resource is found, HttpHandle prepares the http response header with 200 OK status, append the content and send the response.
3. If resource is not found, HttpHandler sends 404 Not Found.
4. HttpHandler also sends the resource name, client port number and client IP address to the Server.


#### Implementation Details:
1. It looks for a directory called www, located in the same parent directory as your HTTP server
executable. The www directory should contain resources you want your HTTP server to serve. If this
directory does not exist, the HTTP server outputs an error message and quit.
2. The date and time in the HTTP ResponseHeader is originated in the format defined by RFC 7231 Date/Time
Formats 2.
3. Upon successfully serving a request, your HTTP server must write to standard output (stdout) the following
items:
  requested resource
  client IP client’s IP address in dotted decimal representation
  client port client’s port number
  access times the number of times this resource has been requested since the start of the HTTP server

### Sample Input/Output:
##### Step 1: Follow the instructions to execute to start the server.
Output:
====================Server Details====================
Server Machine: 168.192.121.1
Port number: 8080 

##### Step 2: On client machine run the wget to get resource. After the input is executed the file gets downloaded as client side.
Input:
wget http:/168.192.121.1:8080/test.htm

##### Step 3: At Server Side
Output:
====================Server Details====================
Server Machine: 168.192.121.1
Port number: 8080

test.htm|128.226.180.163|46940|1

Note: After the input is executed the file gets downloaded as client side.

##### Step 4: Unknown resource is given as input at client side.
Input:
wget http://168.192.121.1:8080/abc.txt

##### Step 5:
Output: NO change as the file is not Found. Http 404 Not Found Error at client side.

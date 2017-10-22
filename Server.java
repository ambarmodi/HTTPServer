import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

/**
 * @author ambarmodi
 *
 */
public class Server {
	private static int PORT = 8080;
	private ServerSocket serverSocket;
	private static HashMap<String,Integer> requestedRes = new HashMap<String,Integer>();
	private static final String DELIMITER = "|";
	
	public static void main(String[] args) {
		try {
			System.out.println("\n====================Server Details====================");
			System.out.println("Server Machine: "+ InetAddress.getLocalHost().getCanonicalHostName());
			System.out.println("Port number: " + PORT);
			System.out.println();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Here one instance of server is started..	
		try {	
			Server server = new Server();
			server.start();
			
		} catch (IOException e) {
			System.err.println("Error occured:" + e.getMessage());
			System.exit(0);
		}
	}
	
	public Server() throws IOException {
			serverSocket = new ServerSocket(PORT);		
	}

	/**
	 * @throws IOException
	 */
	private void start() throws IOException {
		while (true) {
			Socket socket = serverSocket.accept();
			HttpHandler connection = new HttpHandler(socket);

			Thread request = new Thread(connection);
			request.start();
		}
	}
	

	/**
	 * 
	 * @param res
	 * @param port2
	 * @param ipAddress
	 */
	public static void printResult(String res, int port2, String ipAddress) {
		ipAddress = ipAddress.split(":")[0].replace("/", "");
		if(requestedRes.get(res) == null) {
			requestedRes.put(res, 1);
		} else {
			requestedRes.put(res, requestedRes.get(res) + 1);
		}
		System.out.println(res + DELIMITER+ ipAddress + DELIMITER + port2 +DELIMITER + requestedRes.get(res));
	}

}

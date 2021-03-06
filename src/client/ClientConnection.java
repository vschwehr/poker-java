/**
 * 
 */
package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Vernon Schwehr
 *
 */
public class ClientConnection {

	private static final String HOST = "localhost";
	private static final int PORT = 2233;
	private static Socket clientSocket;
	
	public static void main(String args[]) {
		connect();
	}
	
	public static void connect() {
		try {
			clientSocket = new Socket(HOST, PORT);
			
			ClientRunnable runnable = new ClientRunnable(clientSocket);
			
			Thread newThread = new Thread(runnable);
			newThread.start();
		} catch (UnknownHostException e) {
			System.err.println("UnknownHostException: "+e.getMessage());
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("IOException: "+e.getMessage());
			System.exit(-1);
		}
	}
	
	public static void disconnect() {
		try {
			if(clientSocket != null) {
				clientSocket.close();
			}
		} catch (IOException e) {
			System.err.println("IOException: "+e.getMessage());
			System.exit(-1);
		}
	}
	
}

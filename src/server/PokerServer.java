/**
 * 
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Vernon Schwehr
 *
 */
public class PokerServer {

	private static final int PORT = 2233;
	private static boolean start = false;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket listener;
		
		try {
			listener = new ServerSocket(getPort());
			Socket server;
			
			start = true;
			while(start) {
				server = listener.accept();
				PokerRunnable pt = new PokerRunnable(server);
				Thread newThread = new Thread(pt);
				newThread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the port
	 */
	public static int getPort() {
		return PORT;
	}

}

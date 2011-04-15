/**
 * 
 */
package client.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import client.socket.model.Client;
import client.view.Main;

/**
 * @author Vernon Schwehr
 *
 */
public class ClientRunnable implements Runnable {

	private final Socket server;
	
	public ClientRunnable(Socket server) {
		this.server = server;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try { 
			BufferedReader in = new BufferedReader(
					new InputStreamReader(server.getInputStream()));
			PrintStream out = new PrintStream(server.getOutputStream());
			
			Client client = new Client(in, out);
			
			//starts application
			Main main = new Main(client);
			main.start();
		} catch (IOException e) {
			System.err.println("IOException: "+e.getMessage());
			System.exit(-1);
		}
	}

}

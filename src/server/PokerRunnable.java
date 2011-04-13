/**
 * 
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import client.view.MainMenu;


/**
 * @author Vernon Schwehr
 *
 */
public class PokerRunnable implements Runnable {

	private Socket server;
	
	public PokerRunnable(Socket server) {
		this.server = server;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			PrintStream out = new PrintStream(server.getOutputStream());
			BufferedReader in = new BufferedReader(
					new InputStreamReader(server.getInputStream()));
			
			out.println("Connected to server...");
			out.println("Starting main menu...");
			
			//provide user with options
			new MainMenu(out, in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

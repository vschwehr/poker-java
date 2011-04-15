/**
 * 
 */
package client.socket.model;

import java.io.BufferedReader;
import java.io.PrintStream;

/**
 * @author Vernon Schwehr
 *
 */
public class Client {

	private final BufferedReader in;
	private final PrintStream out;
	
	public Client(BufferedReader in, PrintStream out) {
		this.in = in;
		this.out = out;
	}

	/**
	 * @return the in
	 */
	public BufferedReader getIn() {
		return in;
	}

	/**
	 * @return the out
	 */
	public PrintStream getOut() {
		return out;
	}
	
}

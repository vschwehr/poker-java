/**
 * 
 */
package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Vernon Schwehr
 *
 */
public class MainMenu {
	
	private static final int LOGIN_OPTION = 1;
	private static final int REGISTER_OPTION = 2;
	private static final int EXIT_OPTION = 3;
	
	private PrintStream out;
	private BufferedReader in;
	
	public MainMenu(PrintStream out, BufferedReader in) {
		this.out = out;
		showMenu();
	}

	public void showMenu() {
		out.println();
		out.println("Main Menu");
		out.println("1. Login");
		out.println("2. Register");
		out.println("3. Exit");
		out.print("Please enter the number of the option you want to" +
				"choose: ");
		
		requestMenuInput();
	}
	
	public void requestMenuInput() {
		try {
			int i = -1;
			try {
				i = Integer.parseInt(in.readLine());
			} catch (NumberFormatException nfe) {
				out.println("Please type a valid number.");
				showMenu();
			}
			
			if(i != -1) {
				switch(i) {
					case LOGIN_OPTION:
						doLogin();
						break;
					case REGISTER_OPTION:
						doRegister();
						break;
					case EXIT_OPTION:
						doExit();
						break;
					default:
						showMenu();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doLogin() {
		// TODO Auto-generated method stub
		out.println();
		out.print("Username: ");
		
	}
	
	private void doRegister() {
		// TODO Auto-generated method stub
		
	}
	
	private void doExit() {
		// TODO Auto-generated method stub
		
	}	
	
}

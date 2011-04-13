/**
 * 
 */
package server.data;

/**
 * @author Vernon Schwehr
 *
 */
public class User {

	private String userName;
	private String password;
	
	public User(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
}

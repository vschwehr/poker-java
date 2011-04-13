/**
 * 
 */
package client.model;

/**
 * @author Vernon Schwehr
 *
 */
public class Player {

	private final String name;
	private int score;
	private int points = 0;
	private Hand hand;
	private boolean isDealer = false;
	private boolean isSmallBlind = false;
	private boolean isBigBlind = false;
	
	public Player(String name, int startingScore) {
		this.name = name;
		this.setScore(startingScore);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param hand the hand to set
	 */
	public void setHand(Hand hand) {
		this.hand = hand;
	}

	/**
	 * @return the hand
	 */
	public Hand getHand() {
		return hand;
	}
	
	public String printPlayer() {
		return name + " " + score + " " + hand.toString() 
			   + " Dealer? " +  isDealer() + " Small blind? " + isSmallBlind()
			   + " Big Blind? " + isBigBlind();
	}

	/**
	 * @param isDealer the isDealer to set
	 */
	public void setDealer(boolean isDealer) {
		this.isDealer = isDealer;
	}

	/**
	 * @return the isDealer
	 */
	public boolean isDealer() {
		return isDealer;
	}

	/**
	 * @param isSmallBlind the isSmallBlind to set
	 */
	public void setSmallBlind(boolean isSmallBlind) {
		this.isSmallBlind = isSmallBlind;
	}

	/**
	 * @return the isSmallBlind
	 */
	public boolean isSmallBlind() {
		return isSmallBlind;
	}

	/**
	 * @param isBigBlind the isBigBlind to set
	 */
	public void setBigBlind(boolean isBigBlind) {
		this.isBigBlind = isBigBlind;
	}

	/**
	 * @return the isBigBlind
	 */
	public boolean isBigBlind() {
		return isBigBlind;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
	
}

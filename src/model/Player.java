/**
 * 
 */
package model;

/**
 * @author Vernon Schwehr
 *
 */
public class Player {

	private final String name;
	private int score;
	private Hand hand;
	
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
		return name + " " + score + " " + hand.toString();
	}
	
}

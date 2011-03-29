/**
 * 
 */
package model;

/**
 * @author Vernon Schwehr
 *
 */
public class Card {
	
	private final String suit;
	private final int value;
	
	public Card(String suit, int value) {
		this.suit = suit;
		this.value = value;
	}

	/**
	 * @return the suit
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	
	public String toString() {
		return suit + " " + value;
	}
	
}

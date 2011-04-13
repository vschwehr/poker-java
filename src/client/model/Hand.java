/**
 * 
 */
package client.model;

/**
 * @author Vernon Schwehr
 *
 */
public class Hand {

	private final Card card1;
	private final Card card2;
	
	public Hand(Card card1, Card card2) {
		this.card1 = card1;
		this.card2 = card2;
	}

	/**
	 * @return the card1
	 */
	public Card getCard1() {
		return card1;
	}

	/**
	 * @return the card2
	 */
	public Card getCard2() {
		return card2;
	}
	
	public String toString() {
		return card1.toString() + " " + card2.toString();
	}
	
}

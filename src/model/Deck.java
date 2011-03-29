/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Vernon Schwehr
 *
 */
public class Deck extends ArrayList<Card>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7721847752713001124L;
	private static final String HEART = "heart";
	private static final String DIAMOND = "diamond";
	private static final String SPADE = "spade";
	private static final String CLUB = "club";
	
	public Deck() {
		initHeart();
		initDiamond();
		initSpade();
		initClub();
	}

	private void initClub() {
		for(int i = 1; i <= 13; i++) {
			this.add(new Card(CLUB, i));
		}
	}

	private void initSpade() {
		for(int i = 1; i <= 13; i++) {
			this.add(new Card(SPADE, i));
		}
	}

	private void initDiamond() {
		for(int i = 1; i <= 13; i++) {
			this.add(new Card(DIAMOND, i));
		}
	}

	private void initHeart() {
		for(int i = 1; i <= 13; i++) {
			this.add(new Card(HEART, i));
		}
	}
	
}

/**
 * 
 */
package client.model;

import java.util.ArrayList;

/**
 * @author Vernon Schwehr
 *
 */
@SuppressWarnings("serial")
public class CommunityCards extends ArrayList<Card>{

	private Deck deck;
	private int deckIndex;
	private int index = 0;
	private ArrayList<Card> flop;
	private Card turn;
	private Card river;
	
	public CommunityCards(Deck deck, int index) {
		this.deck = deck;
		this.deckIndex = index;
		this.setFlop();
		this.setTurn();
		this.setRiver();
	}
	
	private void setFlop() {
		flop = new ArrayList<Card>();
		int i;
		for(i = deckIndex; i < deckIndex+3; i++) {
			this.add(deck.get(i));
			index++;
			flop.add(deck.get(i));
		}
		deckIndex = i;
	}
	
	public ArrayList<Card> getFlop() {
		return flop;
	}
	
	private void setTurn() {
		turn = deck.get(deckIndex);
		this.add(turn);
		index++;
		deckIndex++;
	}
	
	public Card getTurn() {
		return turn;
	}
	
	private void setRiver() {
		river = deck.get(deckIndex);
		this.add(river);
	}
	
	public Card getRiver() {
		return river;
	}
	
}

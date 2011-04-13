/**
 * 
 */
package client.controller;

import java.util.Collections;

import client.model.Card;
import client.model.Deck;


/**
 * 
 * @author Vernon Schwehr
 *
 */
public class ShuffleController {
	
	private final Deck deck;
	
	public ShuffleController() {
		this.deck = new Deck();
	}

	public void doShuffle() {
		Collections.shuffle(this.getDeck());
		printDeck();
	}
	
	private void printDeck() {
		for(Card card : this.getDeck()) {
			System.out.println(card.toString());
		}
	}

	/**
	 * @return the deck
	 */
	public Deck getDeck() {
		return deck;
	}
	
}

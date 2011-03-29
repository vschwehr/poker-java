/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.Deck;
import model.Hand;
import model.Player;

/**
 * @author Vernon Schwehr
 *
 */
public class CardController {

	private ArrayList<Player> players;
	private final Deck deck;
	private int index;

	public CardController(ArrayList<Player> players, Deck deck) {
		this.players = players;
		this.deck = deck;
		this.index = 0;
	}
	
	public void dealDeck() {
		if(index < 52) {
			for(Player player : players) {
				player.setHand(new Hand(deck.get(index), deck.get(index+1)));
				index += 2;
			}
		}
	}
	
}

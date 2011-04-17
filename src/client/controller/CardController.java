/**
 * 
 */
package client.controller;

import java.util.ArrayList;

import client.model.CommunityCards;
import client.model.Deck;
import client.model.Hand;
import client.model.Player;


/**
 * @author Vernon Schwehr
 *
 */
public class CardController {

	private ArrayList<Player> players;
	private final Deck deck;
	private int index;
	private CommunityCards cc;

	public CardController(ArrayList<Player> players, Deck deck) {
		this.players = players;
		this.deck = deck;
		this.index = 0;
	}
	
	public void dealPlayerHand() {
		if(index < 52) {
			for(Player player : players) {
				player.setHand(new Hand(deck.get(index), deck.get(index+1)));
				index += 2;
			}
		}
		cc = new CommunityCards(deck, index);
	}

	public void dealFlop() {
		for(int i = 0; i < 3; i++) {
			System.out.println(cc.get(i).toString());
		}
	}
	
	public void dealRiver() {
		for(int i = 0; i < 4; i++) {
			System.out.println(cc.get(i).toString());
		}
	}
	
	public void dealTurn() {
		for(int i = 0; i < cc.size(); i++) {
			System.out.println(cc.get(i).toString());
		}
	}
	
}

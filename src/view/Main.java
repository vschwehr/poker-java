package view;

import java.util.ArrayList;
import java.util.Collections;

import model.Card;
import model.Deck;
import model.Player;
import controller.CardController;
import controller.ShuffleController;
import controller.TurnController;

public class Main {
	
	private static Deck deck;
	private static ArrayList<Player> players;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		players = new ArrayList<Player>();
		players.add(new Player("Vernon", 500));
		players.add(new Player("Chanel", 500));
		players.add(new Player("Avita", 500));
		players.add(new Player("Richmond", 500));
		players.add(new Player("Richard", 500));
		
		Collections.shuffle(players);
		
		TurnController tc = new TurnController(players);
		
		ShuffleController sc = new ShuffleController();
		sc.doShuffle();
		deck = sc.getDeck();
		CardController cc = new CardController(players, deck);
		cc.dealDeck();
		
		for(Player player : players) {
			System.out.println(player.printPlayer());
		}
		
		while(tc.hasNext()) {
			Player currentPlayer = tc.nextPlayer();
			//do blinds
			//wait for player input to bet
		}
		
		ArrayList<Card> communityCards = cc.dealCommunityCards();
		System.out.println("Community Cards:");
		for(Card card : communityCards) {
			System.out.println(card.toString());
		}
	}

}

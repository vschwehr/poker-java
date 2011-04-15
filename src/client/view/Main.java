package client.view;

import java.util.ArrayList;
import java.util.Collections;

import client.controller.CardController;
import client.controller.HandController;
import client.controller.PlayerController;
import client.controller.ScoreController;
import client.controller.ShuffleController;
import client.controller.TurnController;
import client.model.Card;
import client.model.CommunityCards;
import client.model.Deck;
import client.model.Player;
import client.socket.model.Client;


public class Main {
	
	private static Deck deck;
	private static final int SMALL_BLIND = 5;
	private static final int BIG_BLIND = SMALL_BLIND * 2;
	private static PlayerController pc;
	
	private Client client;
	
	public Main(Client client) {
		this.client = client;
	}

	public void start() {
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("Vernon", 500));
		players.add(new Player("Chanel", 500));
		players.add(new Player("Avita", 500));
		players.add(new Player("Richmond", 500));
		players.add(new Player("Richard", 500));
		pc = new PlayerController(players);
		
		System.out.println("Welcome to schwehringHil's Texas Hold'em!");
		System.out.println("Small blinds will be: $"+SMALL_BLIND);
		System.out.println("Big blinds will be: $"+BIG_BLIND);
		
		ScoreController scc = new ScoreController(players, SMALL_BLIND);
		TurnController tc = new TurnController(players, scc);
		
		ShuffleController sc = new ShuffleController();
		sc.doShuffle();
		deck = sc.getDeck();
		CardController cc = new CardController(players, deck);
		cc.dealDeck();
		
		for(Player player : pc.getPlayers()) {
			System.out.println(player.printPlayer());
		}
		
		while(tc.hasNext()) {
			Player currentPlayer = tc.nextPlayer();
			//do blinds
			//wait for player input to bet
		}
		
		CommunityCards communityCards = new CommunityCards(deck, players.size()*2);
		System.out.println("Community Cards:");
		for(Card card : communityCards) {
			System.out.println(card.toString());
		}
		HandController hc = new HandController(players, communityCards);
		hc.doAnalyzeCCards();
		System.out.println(hc.getcCardPoints());
	}

	/**
	 * @param args
	 */
	@Deprecated
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("Vernon", 500));
		players.add(new Player("Chanel", 500));
		players.add(new Player("Avita", 500));
		players.add(new Player("Richmond", 500));
		players.add(new Player("Richard", 500));
		pc = new PlayerController(players);
		
		System.out.println("Welcome to schwehringHil's Texas Hold'em!");
		System.out.println("Small blinds will be: $"+SMALL_BLIND);
		System.out.println("Big blinds will be: $"+BIG_BLIND);
		
		ScoreController scc = new ScoreController(players, SMALL_BLIND);
		TurnController tc = new TurnController(players, scc);
		
		ShuffleController sc = new ShuffleController();
		sc.doShuffle();
		deck = sc.getDeck();
		CardController cc = new CardController(players, deck);
		cc.dealDeck();
		
		for(Player player : pc.getPlayers()) {
			System.out.println(player.printPlayer());
		}
		
		while(tc.hasNext()) {
			Player currentPlayer = tc.nextPlayer();
			//do blinds
			//wait for player input to bet
		}
		
		CommunityCards communityCards = new CommunityCards(deck, players.size()*2);
		System.out.println("Community Cards:");
		for(Card card : communityCards) {
			System.out.println(card.toString());
		}
		HandController hc = new HandController(players, communityCards);
		hc.doAnalyzeCCards();
		System.out.println(hc.getcCardPoints());
	}

}

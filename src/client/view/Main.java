package client.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import client.controller.CardController;
import client.controller.PlayerController;
import client.controller.ScoreController;
import client.controller.ShuffleController;
import client.controller.RoundController;
import client.model.Deck;
import client.model.Player;
import client.socket.model.Client;

public class Main {

	private static Deck deck;
	private static final int SMALL_BLIND = 5;
	private static final int BIG_BLIND = SMALL_BLIND * 2;
	private static PlayerController pc;
	private static RoundController rc;

	// private Client client;

	public Main(Client client) {
		// this.client = client;
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
		System.out.println("Small blinds will be: $" + SMALL_BLIND);
		System.out.println("Big blinds will be: $" + BIG_BLIND);

		ShuffleController sc = new ShuffleController();
		sc.doShuffle();
		deck = sc.getDeck();
		CardController cc = new CardController(players, deck);
		cc.dealPlayerHand();

		ScoreController scc = new ScoreController(players, SMALL_BLIND);
		RoundController rc = new RoundController(players, scc, cc);

		for (Player player : pc.getPlayers()) {
			System.out.println(player.printPlayer());
		}

		rc.doRound();

		/*
		 * HandController hc = new HandController(players, communityCards);
		 * hc.doAnalyzeCards(); System.out.println(hc.getcCardPoints());
		 */
	}

	@Deprecated
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("Vernon", 500));
		players.add(new Player("Chanel", 500));
		players.add(new Player("Avita", 500));
		players.add(new Player("Richmon", 500));
		players.add(new Player("Richard", 500));
		pc = new PlayerController(players);

		System.out.println("Welcome to schwehringHil's Texas Hold'em!");
		System.out.println("Small blinds will be: $" + SMALL_BLIND);
		System.out.println("Big blinds will be: $" + BIG_BLIND);

		ShuffleController sc = new ShuffleController();
		sc.doShuffle();
		deck = sc.getDeck();
		CardController cc = new CardController(players, deck);
		cc.dealPlayerHand();

		ScoreController scc = new ScoreController(players, SMALL_BLIND);
		rc = new RoundController(players, scc, cc);

		while (true) {
			rc.doRound();
		}

		// HandController hc = new HandController(players, communityCards);
		// hc.doAnalyzeCards();
		// System.out.println("Community Card points: " + hc.getcCardPoints());
	}

	public static void promptTurn(Player player) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println(player.getName() + "'s turn");
		System.out.println("Please choose an option:");
		System.out.println("1. Bet");
		System.out.println("2. Call");

		if (player.isBigBlind())
			System.out.println("3. Check");
		else
			System.out.println("3. Fold");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int input = 0;

		try {
			input = Integer.parseInt(in.readLine());

			switch (input) {
			case 1:
				// rc.doBet(player);
				System.out.println(player.getName() + " is betting");
				break;
			case 2:
				// rc.doCall(player);
				System.out.println(player.getName() + " is calling");
				break;
			case 3:
				if (player.isBigBlind())
					System.out.println(player.getName() + " is checking");
				else
					System.out.println(player.getName() + " is folding");
				break;
			default:
				System.out.println("Please enter a valid option.");
				promptTurn(player);
				break;
			}

		} catch (NumberFormatException nfe) {
			System.out.println("Please enter a valid option.");
			promptTurn(player);
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}

}

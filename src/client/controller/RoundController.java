/**
 * 
 */
package client.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import client.model.Player;
import client.view.Main;


/**
 * @author Vernon Schwehr
 *
 */
public class RoundController {

	private final ArrayList<Player> players;
	private Queue<Player> playerQueue;
	private ScoreController sc;
	private CardController cc;
	private static int roundCount;
	
	public RoundController(ArrayList<Player> players, 
			ScoreController sc,
			CardController cc) {
		this.players = players;
		this.sc = sc;
		this.cc = cc;
		resetRoundCount();
		this.setQueue();
	}
	
	private void setQueue() {
		this.playerQueue = new LinkedList<Player>(this.players);
		this.setBigBlind(true);
		this.setSmallBlind(true);
		this.setDealer(true);
	}
	
	private void resetQueue() {
		this.setBigBlind(false);
		this.setSmallBlind(false);
		this.setDealer(false);
		
		Player temp = this.players.get(this.players.size()-1);
		this.players.remove(this.players.size()-1);
		this.players.add(0, temp);
		this.playerQueue = new LinkedList<Player>(this.players);
		
		this.setBigBlind(true);
		this.setSmallBlind(true);
		this.setDealer(true);
	}
	
	private static void resetRoundCount() {
		roundCount = 0;
	}
	
	public void doRound() {
		roundCount++;
		
		sc.doOpenRound();
		
		for (Player player : players) {
			System.out.println(player.printPlayer());
		}
		
		while(playerQueue.peek() != null) {
			Player currentPlayer = playerQueue.poll();
			
			Main.promptTurn(currentPlayer);
		}
		
		if(roundCount == 1) {
			cc.dealFlop();
		} else if (roundCount == 2) {
			cc.dealRiver();
		} else if (roundCount == 3) {
			cc.dealTurn();
		} else if (roundCount > 3) {
			resetRoundCount();
		}
		
		resetQueue();
	}
	
	private void setDealer(boolean isDealer) {
		players.get(players.size()-3).setDealer(isDealer);
	}
	
	private void setSmallBlind(boolean isSmallBlind) {
		players.get(players.size()-2).setSmallBlind(isSmallBlind);
	}	
	
	private void setBigBlind(boolean isBigBlind) {
		players.get(players.size()-1).setBigBlind(isBigBlind);
	}

	public void doBet(int bet, Player player) {
		// TODO Auto-generated method stub
		
	}

	public void doCall(int call, Player player) {
		// TODO Auto-generated method stub
		
	}
	
}

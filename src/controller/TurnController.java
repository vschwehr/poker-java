/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import model.Player;

/**
 * @author Vernon Schwehr
 *
 */
public class TurnController {

	private final ArrayList<Player> players;
	private Queue<Player> playerQueue;
	private ScoreController sc;
	
	public TurnController(ArrayList<Player> players, ScoreController sc) {
		this.players = players;
		this.playerQueue = new LinkedList<Player>(this.players);
		this.sc = sc;
		this.setBigBlind();
		this.setSmallBlind();
		this.setDealer();
		this.doBettingRound();
	}
	
	private void doBettingRound() {
		sc.doOpenRound();
	}
	
	private void setDealer() {
		players.get(players.size()-3).setDealer(true);
	}
	
	private void setSmallBlind() {
		players.get(players.size()-2).setSmallBlind(true);
	}	
	
	private void setBigBlind() {
		players.get(players.size()-1).setBigBlind(true);
	}

	public Player nextPlayer() {
		return this.playerQueue.poll();
	}
	
	public boolean hasNext() {
		return (this.playerQueue.peek() != null);
	}
	
}

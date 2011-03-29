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
	
	public TurnController(ArrayList<Player> players) {
		this.players = players;
		this.playerQueue = new LinkedList<Player>(this.players);
	}

	public Player nextPlayer() {
		return this.playerQueue.poll();
	}
	
	public boolean hasNext() {
		return (this.playerQueue.peek() != null);
	}
	
}

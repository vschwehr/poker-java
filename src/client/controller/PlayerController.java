/**
 * 
 */
package client.controller;

import java.util.ArrayList;
import java.util.Collections;

import client.model.Player;


/**
 * @author vs
 *
 */
public class PlayerController {

	private ArrayList<Player> players;
	
	public PlayerController(ArrayList<Player> players) {
		this.setPlayers(players);
		Collections.shuffle(players);
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void removePlayer(Player player) {
		players.remove(player);
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
}

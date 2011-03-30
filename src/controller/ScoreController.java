/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.Player;

/**
 * @author Vernon Schwehr
 *
 */
public class ScoreController {

	private ArrayList<Player> players;
	private int smallBlind;
	private int bigBlind;
	private int pot = 0;
	private int call = 0;
	private int bet = 0;
	private int raise = 0;
	
	public ScoreController(ArrayList<Player> players, int smallBlind) {
		this.players = players;
		this.smallBlind = smallBlind;
		this.bigBlind = this.smallBlind * 2;
	}
	
	public void doOpenRound() {
		for(Player player : players) {
			if(player.isBigBlind()) {
				player.setScore(player.getScore() - bigBlind);
			} else if(player.isSmallBlind()) {
				player.setScore(player.getScore() - smallBlind);
			}
		}
		setCall(bigBlind);
		increasePot(bigBlind + smallBlind);
	}
	
	public void doCloseRound() {
		setPot(0);
	}
	
	private void setPot(int pot) {
		this.pot = pot;
	}

	/**
	 * @param pot the pot to set
	 */
	private void increasePot(int pot) {
		this.pot += pot;
	}

	/**
	 * @return the pot
	 */
	public int getPot() {
		return pot;
	}
	
	public void doCall(int call, Player player) {
		if(bet > 0 || raise > 0) {
			player.setScore(player.getScore() - call);
			increasePot(call);
		}
	}
	
	public void doBet(int bet, Player player) {
		player.setScore(player.getScore() - bet);
		setBet(bet);
		increaseRaise(bet);
		setCall(bet);
		increasePot(bet);
	}
	
	public void doRaise(int raise, Player player) {
		player.setScore(player.getScore() - raise);
		setRaise(raise);
		setCall(raise);
		increasePot(raise);
	}

	/**
	 * @param bet the bet to set
	 */
	public void setBet(int bet) {
		this.bet = bet;
	}

	/**
	 * @return the bet
	 */
	public int getBet() {
		return bet;
	}

	public void increaseRaise(int raise) {
		this.raise += raise;
	}
	
	/**
	 * @param raise the raise to set
	 */
	public void setRaise(int raise) {
		this.raise = raise;
	}

	/**
	 * @return the raise
	 */
	public int getRaise() {
		return raise;
	}

	/**
	 * @param call the call to set
	 */
	public void setCall(int call) {
		this.call = call;
	}

	/**
	 * @return the call
	 */
	public int getCall() {
		return call;
	}
	
}

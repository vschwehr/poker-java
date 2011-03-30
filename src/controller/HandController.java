/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.Card;
import model.CommunityCards;
import model.Hand;
import model.Player;

/**
 * @author Vernon Schwehr
 *
 */
public class HandController {
	
	private static final int ROYAL_FLUSH = 10;
	private static final int STRAIGHT_FLUSH = 9;
	private static final int FOUR_OF_A_KIND = 8;
	private static final int FULL_HOUSE = 7;
	private static final int FLUSH = 6;
	private static final int STRAIGHT = 5;
	private static final int THREE_OF_A_KIND = 4;
	private static final int TWO_PAIR = 3;
	private static final int PAIR = 2;
	private static final int HIGH_CARD = 1; 

	private final HashMap<Player, Hand> hands;
	private final CommunityCards cCards;
	private final ArrayList<Player> players;
	private int points;
	private int playerPoints;
	private int cCardPoints;
	
	public HandController(ArrayList<Player> players, CommunityCards cCards) {
		this.players = players;
		hands = new HashMap<Player, Hand>();
		for(Player player : this.players) {
			hands.put(player, player.getHand());
		}
		this.cCards = cCards;
	}
	
	public void doAnalyzeCCards() {
		ArrayList<Card> cards = new ArrayList<Card>();
		if(cCards.size() == 3) {
			cards.add(cCards.get(0));
			cards.add(cCards.get(1));
			cards.add(cCards.get(2));
			
			setcCardPoints(checkHighCard(cards));
			setcCardPoints(checkValueEquality(cards));
		} 
		if(cCards.size() == 4) {
			cards.add(cCards.get(0));
			cards.add(cCards.get(1));
			cards.add(cCards.get(2));
			cards.add(cCards.get(3));
			
			setcCardPoints(checkHighCard(cards));
			setcCardPoints(checkValueEquality(cards));
		} 
		if(cCards.size() == 5) {
			cards.add(cCards.get(0));
			cards.add(cCards.get(1));
			cards.add(cCards.get(2));
			cards.add(cCards.get(3));
			cards.add(cCards.get(4));
			
			if(points == 0)
				setcCardPoints(checkRoyalFlush(cards));
			if(points == 0)
				setcCardPoints(checkStraightFlush(cards));
			if(points == 0)
				setcCardPoints(checkFullHouse(cards));
			if(points == 0)
				setcCardPoints(checkFlush(cards));
			if(points == 0)
				setcCardPoints(checkStraight(cards));
			if(points == 0)
				setcCardPoints(checkValueEquality(cards));
			if(points == 0)
				setcCardPoints(checkHighCard(cards));
		}
	}

	private int checkRoyalFlush(ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		
		return points;
	}

	private int checkStraightFlush(ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		
		return points;
	}

	private int checkFullHouse(ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		
		return points;
	}

	private int checkFlush(ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		
		return points;		
	}

	private int checkStraight(ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		
		return points;
	}

	/**
	 * For checking for pair, two pair, 3 of a kind, or 4 of a kind in the 
	 * community cards.
	 */
	private int checkValueEquality(ArrayList<Card> cards) {
		
		ArrayList<Card> residual = new ArrayList<Card>();
		ArrayList<Card> pair1 = new ArrayList<Card>();
		ArrayList<Card> pair2 = new ArrayList<Card>();
		if(cards.size() >= 4) {
			for(int i = 0; i < cards.size()-1; i++) {
				for(int j = i+1; j < cards.size(); j++) {
					if(!cards.get(i).equals(cards.get(j)) && 
							cards.get(i).getValue() == cards.get(j).getValue()) {
						points = PAIR;
						pair1.add(cards.get(i));
						pair1.add(cards.get(j));
						break;
					} else if(!residual.contains(cards.get(j))){ 
						residual.add(cards.get(j));
					}
				}
			}
			if(points == PAIR) {
				for(int i = 0; i < residual.size()-1; i++) {
					for(int j = i+1; j < residual.size(); j++) {
						if(residual.get(i).getValue() 
								== residual.get(j).getValue()) {
							points = TWO_PAIR;
							pair2.add(residual.get(i));
							pair2.add(residual.get(j));
							break;
						}
					}
				}
				if(points == PAIR) {
					for(int i = 0; i < residual.size(); i++) {
						if(residual.get(i).getValue() 
								== pair1.get(0).getValue()) {
							points = THREE_OF_A_KIND;
						}
					}
				}
			}
			if(points == TWO_PAIR) {
				for(int i = 0; i < pair1.size(); i++) {
					if(pair1.get(i).getValue() == pair2.get(i).getValue()) {
						points = FOUR_OF_A_KIND;
					}	
				}
			}
		}
		return points;
	}

	/**
	 * For checking high cards in the community cards.
	 */
	private int checkHighCard(ArrayList<Card> cards) {
		if(points != 0)
			points = 0;
		
		int max = 0;
		for(int i = 0; i < cards.size(); i++) {
			if(cards.get(i).getValue() > max) {
				max = cards.get(i).getValue();
				points = HIGH_CARD;
			}
		}
		return points;
	}

	/**
	 * @return the cc
	 */
	public CommunityCards getCc() {
		return cCards;
	}

	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * @param cCardPoints the cCardPoints to set
	 */
	public void setcCardPoints(int cCardPoints) {
		this.cCardPoints = cCardPoints;
	}

	/**
	 * @return the cCardPoints
	 */
	public int getcCardPoints() {
		return cCardPoints;
	}
	
}

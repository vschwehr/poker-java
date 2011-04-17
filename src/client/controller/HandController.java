/**
 * 
 */
package client.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import client.model.Card;
import client.model.CardComparator;
import client.model.CommunityCards;
import client.model.Hand;
import client.model.Player;


/**
 * @author Vernon Schwehr
 *
 */
public class HandController {
	
	public static final int ROYAL_FLUSH = 10;
	public static final int STRAIGHT_FLUSH = 9;
	public static final int FOUR_OF_A_KIND = 8;
	public static final int FULL_HOUSE = 7;
	public static final int FLUSH = 6;
	public static final int STRAIGHT = 5;
	public static final int THREE_OF_A_KIND = 4;
	public static final int TWO_PAIR = 3;
	public static final int PAIR = 2;
	public static final int HIGH_CARD = 1; 

	private final HashMap<Player, Hand> hands;
	private final CommunityCards cCards;
	private final ArrayList<Player> players;
	private int points = 0;
	private int playerPoints;
	//private ArrayList<Card> cards;
	
	public HandController(ArrayList<Player> players, CommunityCards cCards) {
		this.players = players;
		hands = new HashMap<Player, Hand>();
		for(Player player : this.players) {
			hands.put(player, player.getHand());
		}
		this.cCards = cCards;
	}
	
	public void doAnalyzeCards() {
		ArrayList<Card> cards = new ArrayList<Card>();
		if(cCards.size() == 2) {
			cards.add(cCards.get(0));
			cards.add(cCards.get(1));
			cards.add(cCards.get(2));
			
			int points = 0;
			
			points = checkValueEquality(cards);
			//FOUR_OF_A_KIND
			//FULL_HOUSE
			//THREE_OF_A_KIND
			//TWO_PAIR
			//PAIR
			setcCardPoints(points);
			
			if(points == 0) {
				points = checkHighCard(cards);
				setcCardPoints(points);//HIGH_CARD
			}
		} 
		
		if(cCards.size() >= 5) {
			cards.addAll(cCards);
			
			int points = 0;
			
			points = checkRoyalFlush(cards);
			
			if(points != ROYAL_FLUSH) {
				points = checkStraightFlush(cards);
				
				if(points != STRAIGHT_FLUSH) {
					points = checkFlush(cards);
					
					if(points != FLUSH) {
						points = checkStraight(cards);
						
						if(points != STRAIGHT) {
							points = checkValueEquality(cards);
							//FOUR_OF_A_KIND
							//FULL_HOUSE
							//THREE_OF_A_KIND
							//TWO_PAIR
							//PAIR
							setcCardPoints(points);
							
							if(points == 0) {
								points = checkHighCard(cards);
								setcCardPoints(points);//HIGH_CARD
							}
						
						} else {
							setcCardPoints(points);//STRAIGHT
						}
						
					} else {
						setcCardPoints(points);//FLUSH
					}
					
				} else {
					setcCardPoints(points);//STRAIGHT_FLUSH
				}
				
			} else {
				setcCardPoints(points);//ROYAL_FLUSH
			}
		}
	}

	private int checkRoyalFlush(ArrayList<Card> cards) {
		int points = 0;
		
		Collections.sort(cards, new CardComparator());
		
		if(checkFlush(cards) == FLUSH) {
			if(cards.get(0).getValue() == 1) {
				if(cards.get(1).getValue() == 10) {
					if(cards.get(2).getValue() == 11) {
						if(cards.get(3).getValue() == 12) {
							if(cards.get(4).getValue() == 13) {
								points = ROYAL_FLUSH;
							}
						}
					}
				}
			}
		}
		
		return points;
	}

	private int checkStraightFlush(ArrayList<Card> cards) {
		int points = 0;
		
		if(checkStraight(cards) == STRAIGHT_FLUSH) {
			points = STRAIGHT_FLUSH;
		}
		
		return points;
	}

	private int checkFlush(ArrayList<Card> cards) {
		ArrayList<Card> sameSuit = new ArrayList<Card>();
		
		boolean isFlush = false;
		if(cards.size() >= 5) {
			for(int i = 0; i < cards.size()-1; i++) {
				String suit1 = cards.get(i).getSuit();
				for(int j = i+1; j < cards.size(); j++) {
					String suit2 = cards.get(j).getSuit();
					if(suit1.equals(suit2) 
							&& !sameSuit.contains(cards.get(j))) {
						if(!sameSuit.contains(cards.get(i))) {
							sameSuit.add(cards.get(i));
						}
						sameSuit.add(cards.get(j));
					} 
				}
				if(sameSuit.size() > 0 && sameSuit.size() < 5) {
					sameSuit.clear();
				}
				if(sameSuit.size() >= 5) {
					isFlush = true;
					break;
				}
			}
		}
		
		int points = 0;
		
		if(isFlush) {
			if(this.points == STRAIGHT) {
				points = STRAIGHT_FLUSH;
			} else {
				points = FLUSH;
			}
		}
		
		return points;		
	}

	/**
	 * For checking a straight in the cards given.
	 */
	private int checkStraight(ArrayList<Card> cards) {
		Collections.sort(cards, new CardComparator());
		int count = 1;
		int points = 0;
		
		for(int i = 0; i < cards.size()-1; i++) {
			int firstVal = cards.get(i).getValue();
			int nextVal = cards.get(i+1).getValue();
			
			if(firstVal == (nextVal-1)) {
				count++;
			}
			
			if(count == 5) {
				points = STRAIGHT;
				break;
			}
		}
		
		if(points == STRAIGHT) {
			this.points = STRAIGHT;
			if(checkFlush(cards) == STRAIGHT_FLUSH) {
				points = STRAIGHT_FLUSH;
			}
		}
		
		return points;
	}

	/**
	 * For checking for pair, two pair, 3 of a kind, 4 of a kind, or 
	 * full house in the community cards.
	 */
	private int checkValueEquality(ArrayList<Card> cards) {
		ArrayList<Card> residual = new ArrayList<Card>();
		ArrayList<Card> pair1 = new ArrayList<Card>();
		ArrayList<Card> pair2 = new ArrayList<Card>();
		int points = 0;
		
		if(cards.size() >= 4) {
			pair1 = checkPair(cards);
			
			if(pair1.size() == 2)
				points = PAIR;	
			
			for(Card card : cards) {
				if(!pair1.contains(card)) {
					residual.add(card);
				}
			}
			
			if(points == PAIR) {
				pair2 = checkPair(residual);
				
				if(pair2.size() == 2)
					points = TWO_PAIR;
				
				ArrayList<Card> threeOfAKind = new ArrayList<Card>();
				for(int i = 0; i < residual.size(); i++) {
					if(residual.get(i).getValue() 
							== pair1.get(0).getValue()) {
						points = THREE_OF_A_KIND;
					}
					
					if(cards.size() >= 5) {
						if(i < residual.size()-1) {
							if(residual.get(i).getValue() 
									== residual.get(i+1).getValue()) {
								if(!threeOfAKind.contains(residual.get(i))) {
									threeOfAKind.add(residual.get(i));
								}
								
								if(!threeOfAKind.contains(residual.get(i+1))) {
									threeOfAKind.add(residual.get(i+1));
								}
							}
						}
					}
				}
				
				if(threeOfAKind.size() == 3 && pair1.size() == 2) {
					points = FULL_HOUSE;
					return points;
				}
			}
			
			for(int i = 0; i < pair1.size() && i < pair2.size(); i++) {
				if(pair1.get(i).getValue() == pair2.get(i).getValue()) {
					points = FOUR_OF_A_KIND;
					return points;
				}	
			}
		}
		
		return points;
	}

	/**
	 * @param cards
	 * @param pair1
	 */
	private ArrayList<Card> checkPair(ArrayList<Card> cards) {
		ArrayList<Card> pair = new ArrayList<Card>();
		
		for(int i = 0; i < cards.size()-1; i++) {
			for(int j = i+1; j < cards.size(); j++) {
				if(!cards.get(i).equals(cards.get(j)) && 
						cards.get(i).getValue() == cards.get(j).getValue()) {
					pair.add(cards.get(i));
					pair.add(cards.get(j));
					break;
				}
			}
			if(pair.size() == 2) {
				break;
			}
		}
		
		return pair;
	}

	/**
	 * For checking high cards in the community cards.
	 */
	private int checkHighCard(ArrayList<Card> cards) {
		int max = 0;
		int points = 0;
		
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
	private void setcCardPoints(int cCardPoints) {
		this.playerPoints = cCardPoints;
	}

	/**
	 * @return the cCardPoints
	 */
	public int getcCardPoints() {
		return playerPoints;
	}
	
}

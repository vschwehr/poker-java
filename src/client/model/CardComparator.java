/**
 * 
 */
package client.model;

import java.util.Comparator;

/**
 * @author Vernon Schwehr
 *
 */
public class CardComparator implements Comparator<Card> {

	@Override
	public int compare(Card c1, Card c2) {
		// TODO Auto-generated method stub
		int c1Val = c1.getValue();
		int c2Val = c2.getValue();
		
		if(c1Val > c2Val)
			return 1;
		else if(c1Val < c2Val) 
			return -1;
		else 
			return 0;
	}

}

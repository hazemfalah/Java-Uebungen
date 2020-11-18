package java_36_h06;

import java.util.Comparator;

/**
 * 
 * @author Hazem Falah
 * @author Philipp Luhr
 * @author Nils Neumann
 *
 */

public class BlattVergleich implements Comparator<Blatt> {



	/**
	 * control if there is a triple, a pair or all cards are different
	 * 
	 * @param o1
	 * @return 1:all cards are different 2:there is a pair 3:there is a triple
	 */
	private int control(Blatt o1) {
		int characteristics;
		if (o1.getBlatt()[0] == o1.getBlatt()[1] && o1.getBlatt()[0] == o1.getBlatt()[2]) {
			characteristics = 3;
		} else if (o1.getBlatt()[0] == o1.getBlatt()[1] || o1.getBlatt()[1] == o1.getBlatt()[2]
				|| o1.getBlatt()[0] == o1.getBlatt()[2]) {
			characteristics = 2;
		} else {
			characteristics = 1;
		}
		return characteristics;
	}

	/**
	 * 
	 * @param o1
	 * @return the repeated card in a hand with pair
	 */
	private int repeatedCard(Blatt o1) {
		if ((o1.getBlatt()[0] != o1.getBlatt()[1]) && (o1.getBlatt()[0] != o1.getBlatt()[2]))// the first card is not one of the pair
			return o1.getBlatt()[1];

		return o1.getBlatt()[0];
	}

	/**
	 * 
	 * @param o1
	 * @return the sum of all the cards
	 */
	private int sumBlatt(Blatt o1) {
		int sum = o1.getBlatt()[0] + o1.getBlatt()[1] + o1.getBlatt()[2];
		return sum;
	}

	/**
	 * compare two poker-hands
	 * 
	 * @return positive number if o1>o2, 0 if o1 = o2 and a negative number if o1<o2
	 */
	@Override
	public int compare(Blatt o1, Blatt o2) {

		int comparation = 0;
		if (control(o1) * control(o2) == 1)  // if the cards in both hands are different
		{                                   // the sum of both hands will be compared
			comparation = sumBlatt(o1) - sumBlatt(o2);
		} else if (control(o1) == control(o2)) {           // if both have a pair or a triple (triple is an exceptional case of pairs)
			if (repeatedCard(o1) - repeatedCard(o2) == 0) // if the repeated card in both hands are equal 
			{                                            //(normally it is not possible for a triple)
				comparation = (sumBlatt(o1) - 2 * repeatedCard(o1)) - (sumBlatt(o2) - 2 * repeatedCard(o2));// we compare third card
			}
			else
			{
				comparation = repeatedCard(o1) - repeatedCard(o2); // if the repeated card in both hands are unequal
			}													   // we compare the repeated card
		} else { //if both hands doesn't have the same characteristics
			comparation = control(o1) - control(o2); 
		}
		return comparation;
	}
}

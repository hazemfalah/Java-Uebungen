package java_36_h06;

/**
 * 
 * @author Hazem Falah
 * @author Philipp Luhr 
 * @author Nils Neumann 
 *
 */

public class Blatt {
	//Attribute
	private int[] blatt = new int[3];

	/**
	 * generate a hand with the given cards
	 * an Exception will be thrown if the number of the given cards is unequal 3
	 * or if there is a not valid card (valid cards are between 2 (inclusive) and 14 (inclusive)) 
	 * @param blatt
	 */
	public Blatt(int[] blatt)
	{
		setBlatt(blatt);
	}
	
	/**
	 * return all the cards of the poker-hand
	 * @return
	 */
	public int[] getBlatt() {
		return blatt;
	}

	/**
	 * set the given cards, an Exception will be thrown if the number of the given cards is unequal 3
	 * or if there is a not valid card (valid cards are between 2 (inclusive) and 14 (inclusive)) 
	 * @param blatt
	 */
	public void setBlatt(int[] blatt) {
		if(blatt.length != 3)
		{
			throw new NotHandException("not a valid hand. a hand contains exactly 3 cards");
		}
		else {
			boolean b=true;
			int i=0;
		for (i = 0; i < 3; i++) {
			if(blatt[i]<2 || blatt[i]>14)
			{
				b = false;
				break;
			}	
		}
		if(b)
		 this.blatt = blatt.clone();
		else
			throw new NotValidCardException(blatt[i] + " isn't a valid card");
		}
	}
	
	/**
	 * return the poker-hand in the form " card1, card2, card3 "
	 */
	public String toString()
	{
		String s = "" + this.blatt[0];
		for(int i=1;i<3;i++)
		{
			s +=", " + this.blatt[i];
		}
		return s;
	}
}

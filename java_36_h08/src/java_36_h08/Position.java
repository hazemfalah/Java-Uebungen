package java_36_h08;

/**
 * 
 * @author Philipp Luhr
 * @author Hazem Falah
 * @author Nils Neumann
 * 
 *         Represents a Position
 *
 */


public class Position {

	private int x;
	private int y;
	
	/**
	 * Initializes a position
	 * 
	 * @param x position and y position
	 */
	
	public Position(int x, int y)
	{
		setXY(x,y);
	}
	
	/**
	 * set x and y, an exception will be thrown if the position is not valid
	 * x and y must be between 1 and 8 
	 * @param x,y : the coordinate 
	 */
	public void setXY(int x, int y)
	{
		if (isValid(x, y)) {
			this.x = x;
			this.y = y;
		} else {
			throw new WrongPositionException("Wrong Position:x and y must be between 1 and 8 ");
		}
	}
	
	/**
	 * Get x coordinate
	 * 
	 * @return x coordinate
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * Get y coordinate
	 * 
	 * @return y coordinate
	 */
	public int getY()
	{
		return this.y;
	}
	/**
	 * Checks if position is valid
	 * 
	 * @return true if valid
	 */
	public static boolean isValid(int x, int y)
	{
		boolean check = false;
		if(x<= 8 && x >= 1 && y <= 8 && y >= 1)
		 {
			 check=true;
		 }
		return check;
	}
	
	/**
	 * toString method
	 * 
	 * @return Position as string
	 */
	public String toString()
	{
		String s ="(" + this.x + "/" + this.y + ")";
		return s;
	}
	
	
	/**
	 * Checks if position if this object is same as p
	 * 
	 * @param position to be checked
	 * @return true if positions are the same
	 */
	public boolean equals(Position p)
	{
		boolean b = false;
		if(this.x == p.getX() && this.y == p.getY())
		{
			b = true;
		}
		return b;
	}
	
	/**
	 * innere Exception-class
	 */
	public class WrongPositionException extends RuntimeException {
		public WrongPositionException(String s)
		{
			super(s);
		}
	}
}

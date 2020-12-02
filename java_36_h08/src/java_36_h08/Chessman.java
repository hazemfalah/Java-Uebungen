package java_36_h08;

import java.util.ArrayList;


/**
 * 
 * @author Philipp Luhr
 * @author Hazem Falah
 * @author Nils Neumann
 * 
 *         Represents a chessman with a Position
 *
 */
public abstract class Chessman {

	private Position pos;
	
	/**
	 * Initializes a chessman with its position
	 */
	public Chessman(Position pos)
	{
//		this.pos.setXY(pos.getX(), pos.getY()); nullPointerException!!
		this.pos = pos;
	}
	
	/**
	 * 
	 * @return the current position of the figure
	 */
	public Position getPosition()
	{
		return this.pos;
	}
	
	/**
	 * Move figure to position
	 * 
	 * @param pos: position where figure moves to
	 */
	public void moveTo(Position pos)
	{
		if(canMoveTo(pos))
		{
			this.pos.setXY(pos.getX(), pos.getY());
		}
		else
		{
			throw new WrongMoveException("wrong move");
		}
	}
	
	/**
	 * 
	 * @param pos: Position where the figure moves to
	 * @return true if it is possible else false
	 */
	public boolean canMoveTo(Position pos)
	{
		//don't work with contains
		boolean check = false;
		for (int i = 0; i < getMoveList().size(); i++) {
			if (pos.equals(getMoveList().get(i))) {
				check = true;
			}
		}
		return check;
	}
	
	/**
	 * Get ArrayList with possible moves
	 * @return ArrayList with Positions
	 */
	public abstract ArrayList<Position> getMoveList();
	
	public String toString()
	{
		return pos.toString();
	}
	
	/**
	 * innere class
	 *
	 */
	public class WrongMoveException extends RuntimeException{
		public WrongMoveException(String s)
		{
			super(s);
		}
	}
}

package java_36_h07;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Philipp Luhr
 * @author Hazem Falah
 * @author Nils Neumann
 * 
 * Represents a 4x4 playing board with 15 pieces and one empty field. 
 * The goal of the game is to move the pieces to the right place.
 *
 */

public class Schiebepuzzle {
	
	private ArrayList<Integer> board = new ArrayList<>();
	    /**
	     * 
	     */
        public Schiebepuzzle()
        {
        	for(int i=1; i<=15;i++)
        	{
        		this.board.add(i);
        	}
        	this.board.add(0);
        }
        
        /**
    	 * Get the current board.
    	 * @return The position of each piece saved in the ArrayList
    	 */
    	public ArrayList<Integer> getBoard(){
    		return this.board;
    	}
    	
    	/**
    	 * Move a piece to the empty field, if possible.
    	 * @param i Number of the piece that the program will be trying to move
    	 */
    	public void schiebe(int i) {
    		if(i < 1 || i > 15) {
    			throw new WrongNumberException("i must be between 1 and 15");
    		}else if (!istVerschiebbar(i)) {
    			throw new WrongMoveException("The plate with number " + i + " is not movable");
    		}else {
    			int temp = this.board.indexOf(i);
    			this.board.set(this.board.indexOf(0), i);
    			this.board.set(temp, 0);
    		}
    	}
    	
    	/**
    	 * Depending on whether or not the piece is next to the empty field, returns true or false.
    	 * @param i Number of the piece
    	 * @return true if the piece can be moved, false otherwise
    	 */
    	public boolean istVerschiebbar(int i) {
    		if(i < 1 || i > 15) {
    			throw new WrongNumberException("i must be between 1 and 15");
    		}else {
    			int indexOfI = this.board.indexOf(i);
    			int indexOfEmptyField = this.board.indexOf(0);
    			if(indexOfI + 1 == indexOfEmptyField || indexOfI - 1 == indexOfEmptyField || indexOfI - 4 == indexOfEmptyField || indexOfI + 4 == indexOfEmptyField ) {
    				return true;
    			}else {
    				return false;
    			}
//    			int indexOf_0 = this.board.indexOf(0);
//    			int indexOf_I = this.board.indexOf(i);
//            	boolean b = ( (indexOf_I -1 == indexOf_0) || (indexOf_I +1 == indexOf_0 ) || (indexOf_I -4== indexOf_0) || (indexOf_I +4 == indexOf_0) );
//            	return b;
    			}
    		}
    	
    	
    	/**
    	 * Shuffle the board by doing 100 random moves.
    	 * If the move is not possible it doesn't count.
    	 */
    	public void mische() {
    		Random r = new Random();
    		int n = 100;
    		while(n > 0) {
    			try {
    				//because nextInt returns a value between 0(inclusive) and 15(exclusive) we add 1 at the end
    				this.schiebe(r.nextInt(15) + 1);
    				n--;
    			}catch (WrongMoveException e) {
    				
    			}
    		}
    	}
    	/**
    	 * toString method
    	 */
    	public String toString() {
    		String ret = "";
    		for(Integer i : this.board) {
    			if(i == 0) {
    				ret = ret + "|  ";
    			}
    			else if(i < 10) {
    				ret = ret + "| " + i;
    			}else {
    				ret = ret + "|" + i;
    			}
    			
    			if( this.board.indexOf(i) %4 == 3) {
    				ret = ret + "|\n-------------\n";
    			}
    		}
    		return ret;
    	}     
}

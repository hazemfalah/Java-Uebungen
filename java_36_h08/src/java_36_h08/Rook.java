package java_36_h08;

import java.util.ArrayList;

public class Rook extends Chessman {

	public Rook(Position pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Position> getMoveList() {
		ArrayList<Position> posList = new ArrayList<>();
		int x = this.getPosition().getX();
		int y = this.getPosition().getY();
		for(int i = 1; i<8; i++)
		{
		   if(Position.isValid(x, y+i))	
			   posList.add(new Position(x, y+i));
		   if(Position.isValid(x, y-i))	
			   posList.add(new Position(x, y-i));
		   if(Position.isValid(x+i, y))	
			   posList.add(new Position(x+i, y));
		   if(Position.isValid(x-i, y))	
			   posList.add(new Position(x-i, y));
		}
		return posList;
	}
	
	public String toString()
	{
		String s = "Turm: " + this.getPosition().toString();
		return s;
	}

}

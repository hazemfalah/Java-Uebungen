package java_36_h08;

import java.util.ArrayList;

public class Knight extends Chessman{

	public Knight(Position pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Position> getMoveList() {
		ArrayList<Position> posList = new ArrayList<>();
		int x =this.getPosition().getX();
		int y =  this.getPosition().getY();
		int j=2;
		for(int i=1;i<=2;i++)
		{
			if(Position.isValid(x+i, y+j))
				{
					posList.add(new Position(x+i,y+j));
				}
				if(Position.isValid(x+i, y-j))
				{
					posList.add(new Position(x+i,y-j));
				}
				if(Position.isValid(x-i, y-j))
				{
					posList.add(new Position(x-i,y-j));
				}
				if(Position.isValid(x-i, y+j))
				{
					posList.add(new Position(x-i,y+j));
				}
				j--;
		}
		return posList;
	}

	public String toString()
	{
		String s = "Springer" + this.getPosition().toString();
		return s;
	}
}

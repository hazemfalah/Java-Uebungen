package java_36_h05;

public class GefangenenDilemma {

	//Attribute
	private GefangenenStrategie playerA;
	private GefangenenStrategie playerB;
	private int[] results = new int[2];
	
	/**
	 * constructor that initialize the strategy of the two players 
	 * @param playerA
	 * @param playerB
	 */
	public GefangenenDilemma(GefangenenStrategie playerA, GefangenenStrategie playerB)
	{
		this.playerA = playerA;
		this.playerB = playerB;
	}
	
	/**
	 * the game: if both cooperate everyone get 2 points,
	 *           if both betray everyone get 4 points
	 *           if one betray and the other cooperate, the one who betrayed get 1 point and the other 6 points
	 *           true = cooperate , false =  betrayed
	 * @param n: number of rounds
	 */
	public void spiele(int n)
	{
		for(int i=0; i<n; i++)
		{
			boolean decisionA = this.playerA.getNextDecision();
			boolean decisionB = this.playerB.getNextDecision();
//			System.out.println("decision1: "+decisionA+" decision2: "+decisionB);
			if(decisionA == true && decisionB == true)
			{
				results[0] += 2;
				results[1] += 2;	
			}
			if(decisionA == false && decisionB == false)
			{
				results[0] += 4;
				results[1] += 4;
			}
			if(decisionA == false && decisionB == true)
			{
				results[0] += 1;
				results[1] += 6;
			}
			if(decisionA == true && decisionB == false)
			{
				results[0] += 6;
				results[1] += 1;
			}
			this.playerA.setOpponentsLastDecision(decisionB);
			this.playerB.setOpponentsLastDecision(decisionA);
		}
		System.out.println("Ergebnis: 1.Spieler " +this.results[0] +" | 2.Spieler "+ this.results[1]+" ---> " +result());
	}
	
	/**
	 * the result of the game
	 */
	private String result()
	{
		String s="";
		if (this.results[0] == this.results[1])
		{
			s = "It is a draw";
		}
		if (this.results[0] < this.results[1])
		{
			s = "the first player wins";
		}
		if (this.results[0] > this.results[1])
		{
			s = "the second player wins";
		}
		return s;
	}
}
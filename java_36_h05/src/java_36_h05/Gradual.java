package java_36_h05;

/**
 * cooperate until got betrayed the first time, after that change the strategy to betray true true  
 * and after every next time in which the adversary betray, change the strategy 
 *
 */
public class Gradual implements GefangenenStrategie{

	private boolean decision = true;
	private int oftbetrayed = 0;
	private int round=0; // in every sequence he cooperate twice
	
	
	@Override
	public boolean getNextDecision() {
		if(this.round == this.oftbetrayed+2)//start new sequence
		{
			this.round=0;
		}
		if(this.oftbetrayed <=this.round) //that is only possible if  0<= this.round-this.oftbetrayed <2
		{
		  this.decision = true;
		  this.round++;
		}
		else if(this.round< this.oftbetrayed)
		{
			this.decision = false;
			this.round++;
		}
		return this.decision;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		if (decision == false)
		{
			this.oftbetrayed++;
			this.round=0;
		}
		
	}
	
	

}

package java_36_h05;

/**
 * 
 * cooperate until the adversary betray the first time, after that 
 * he betray all the time
 */
public class Spite implements GefangenenStrategie {
 
	boolean decision = true;
	@Override
	public boolean getNextDecision() {
		// TODO Auto-generated method stub
		return this.decision;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		if(decision == false)
			this.decision = false;
	}

}

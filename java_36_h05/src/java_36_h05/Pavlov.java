package java_36_h05;

/**
 * 
 * cooperate the first time, he betray if his decision and the last decision of
 * the adversary are different
 *
 */
public class Pavlov implements GefangenenStrategie {

	private boolean decision = true;

	@Override
	public boolean getNextDecision() {
		// TODO Auto-generated method stub
		return this.decision;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		if (decision == this.decision)
			this.decision = true;
		else
			this.decision = false;
	}

}

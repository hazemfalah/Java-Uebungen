package java_36_h05;

/**
 * cooperate the first time and then he copy always the previous
 * decision of the adversary
 */
public class TitForTat implements GefangenenStrategie{

	private boolean adversaryprvdecision = true;
	@Override
	public boolean getNextDecision() {
		// TODO Auto-generated method stub
		return this.adversaryprvdecision;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
	          this.adversaryprvdecision = decision;
	}

}

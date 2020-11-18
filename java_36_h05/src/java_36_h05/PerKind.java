package java_36_h05;

/**
 * 
 * follow the sequence  cooperate cooperate betray
 *
 */
public class PerKind implements GefangenenStrategie {

	boolean [] decisionfolge= {true, true , false};
	@Override
	public boolean getNextDecision() {
		boolean b = this.decisionfolge[0];
		//translate
		this.decisionfolge[0]=this.decisionfolge[1];
		this.decisionfolge[1]=this.decisionfolge[2];
		this.decisionfolge[2]=b;
		return b;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
	}

}

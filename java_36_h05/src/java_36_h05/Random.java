package java_36_h05;

/**
 * 
 * a completly random decision(50-50)
 *
 */
public class Random implements GefangenenStrategie {

	@Override
	public boolean getNextDecision() {
		double a = Math.random();
		if(a<0.5)
			return true;
		else 
			return false;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
	}

}

package java_36_h05;

public interface GefangenenStrategie {
	/**
	 * the next decision of the player
	 * @return true for say nothing, false for betray
	 */
    boolean getNextDecision();
    
    /**
     * decision based on the last decision of the adversary
     * @param decision
     */
    void setOpponentsLastDecision(boolean decision);
}

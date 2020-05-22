package cardgame.model;

import cardgame.model.Hand;

public class Player{
	private int whichPlayer;
	private Hand hand;

	public Player(int i){
		whichPlayer = i;
		hand = new Hand();
	}

    /**
     * Getter for hand so it may be looked at without being changed
     */
    public Hand getHand() {
        return hand;
    }

    public int getPlayer(){
    	return whichPlayer;
    }
	
}
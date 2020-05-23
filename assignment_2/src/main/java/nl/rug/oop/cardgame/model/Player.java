package nl.rug.oop.cardgame.model;

import nl.rug.oop.cardgame.model.card.Card;

/**
 * A player class
 *
 */
public class Player{
	private Hand hand;
	private int points;

	public Player(int i){
		hand = new Hand();
		points = 0;
	}

    /**
     * Getter for hand so it may be looked at without being changed
	 * @return the cards of the player
     */
    public Hand getHand() {
        return hand;
    }

	/**
	 * Getter for points of the player
	 * @return the string value of the points
	 */
    public String getPointsString() {
    	return String.valueOf(points);
	}

	/**
	 * Getter for points of the player
	 * @return the points of the player (int)
	 */
	public int getPoints() {
    	return points;
	}

	/**
	 * Method that adds the bonus to the player
	 * @param luck true or false
	 */
	public void bonus(boolean luck) {
    	if (luck) {
			points += 100;
		} else {
    		points = 0;
		}
	}

	/**
	 * Method that adds 1 point to the player
	 */
	public void addPoint() {
    	points++;
	}
}


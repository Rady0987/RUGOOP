package nl.rug.oop.cardgame;

import nl.rug.oop.cardgame.model.Game;
import nl.rug.oop.cardgame.view.*;


public class Main {

    public static void main(String[] args) {

	/* Create the game */
        Game game = new Game();
        /* Create  */
        new DrawFrame(game);
	
    }
}

package nl.rug.oop.cardgame;

import cardgame.model.DrawGame;

import cardgame.view.DrawFrame;

public class Main {

    public static void main(String[] args) {

	/* Create the game */
        DrawGame drawGame = new DrawGame();
        /* Create  */
        new DrawFrame(drawGame);
	
    }
}

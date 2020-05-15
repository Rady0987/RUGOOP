package nl.rug.oop.cardgame;

import nl.rug.oop.cardgame.model.Game;
import nl.rug.oop.cardgame.view.gameFrame;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
        //new gameFrame();
    }
}
package nl.rug.oop.cardgame.controller;

import nl.rug.oop.cardgame.controller.buttons.*;
import nl.rug.oop.cardgame.model.Game;
import javax.swing.JMenuBar;

/**
 * Panel with the buttons for the draw-class controllers
 */
public class ButtonBar extends JMenuBar {

    /**
     * Create a new ButtonBar with all the necessary buttons
     *
     * @param game The actual game, passed to the controllers
     */
    public ButtonBar(Game game) {
        add(new DrawButton(game));
        add(new ResetButton(game));
        add(new ButtonOne(game));
        add(new ButtonTwo(game));
        add(new ButtonThree(game));
    }

}

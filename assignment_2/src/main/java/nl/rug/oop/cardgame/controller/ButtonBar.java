package cardgame.controller;

import cardgame.controller.buttons.DrawButton;
import cardgame.controller.buttons.ResetButton;
import cardgame.model.DrawGame;

import javax.swing.JMenuBar;

/**
 * Panel with the buttons for the draw-class controllers
 */
public class ButtonBar extends JMenuBar {

    /**
     * Create a new ButtonBar with all the necessary buttons
     *
     * @param drawGame The actual game, passed to the controllers
     */
    public ButtonBar(DrawGame drawGame) {
        add(new DrawButton(drawGame));
        add(new ResetButton(drawGame));
    }

}

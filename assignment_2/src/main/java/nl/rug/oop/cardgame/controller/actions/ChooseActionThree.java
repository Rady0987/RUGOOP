package nl.rug.oop.cardgame.controller.actions;

import nl.rug.oop.cardgame.model.Game;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * Represents an action made to shuffle all cards back into the deck. Although
 * useless on an empty discard pile, this action is always available.
 */
public class ChooseActionThree extends AbstractAction {

    private Game game;

    /**
     * Creates a new action to shuffle all cards back into the deck
     *
     * @param game The actual DrawGame
     */
    public ChooseActionThree(Game game) {
        super("Option 3");
        this.game = game;
    }

    /**
     * Draws a card
     *
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        game.optionThreeChosen();
    }

}

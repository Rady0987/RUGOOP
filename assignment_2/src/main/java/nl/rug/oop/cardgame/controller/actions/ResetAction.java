package cardgame.controller.actions;

import cardgame.model.DrawGame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Represents an action made to shuffle all cards back into the deck. Although
 * useless on an empty discard pile, this action is always available.
 */
public class ResetAction extends AbstractAction {

    private DrawGame drawGame;

    /**
     * Creates a new action to shuffle all cards back into the deck
     *
     * @param drawGame The actual DrawGame
     */
    public ResetAction(DrawGame drawGame) {
        super("Shuffle");
        this.drawGame = drawGame;
    }

    /**
     * Draws a card
     *
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        drawGame.reset();
    }

}

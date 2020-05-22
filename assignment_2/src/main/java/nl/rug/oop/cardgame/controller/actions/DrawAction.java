package cardgame.controller.actions;

import cardgame.model.DrawGame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import java.util.Observer;
import java.util.Observable;

/**
 * Represents an action made to draw a card.
 */
public class DrawAction extends AbstractAction implements Observer {

    private DrawGame drawGame;

    /**
     * Creates a new action to draw a card.
     *
     * @param drawGame The actual DrawGame
     */
    public DrawAction(DrawGame drawGame) {
        super("Draw a card");
        this.drawGame = drawGame;
        drawGame.addObserver(this);
        fixEnabled();
    }

    /**
     * Makes sure the availability of the action reflects the availability of
     * the resource it acts on, namely, draw.
     */
    private void fixEnabled() {
        if (drawGame.getDeck().isEmpty() && drawGame.getMovableCard() == null) {
            setEnabled(false);
        } else {
            setEnabled(true);
        }
    }

    /**
     * Draws a card
     *
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        drawGame.move();
    }

    /**
     * Since availability of this action depends on the state of the
     * resources it itself depends on, this action verifies
     * after every update of draw if it can still be performed.
     */
    @Override
    public void update(Observable observed, Object message) {
        fixEnabled();
    }

}

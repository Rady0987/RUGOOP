package nl.rug.oop.cardgame.controller.actions;

import nl.rug.oop.cardgame.model.Game;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import java.util.Observer;
import java.util.Observable;

/**
 * Represents an action made to draw a card.
 */
public class DrawAction extends AbstractAction implements Observer {

    private Game game;

    /**
     * Creates a new action to draw a card.
     *
     * @param game The actual DrawGame
     */
    public DrawAction(Game game) {
        super("Draw a card");
        this.game = game;
        game.addObserver(this);
        fixEnabled();
    }

    /**
     * Makes sure the availability of the action reflects the availability of
     * the resource it acts on, namely, draw.
     */
    private void fixEnabled() {
        if (game.getDeck().isEmpty() && game.getMovableCard() == null) {
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
        game.move();
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

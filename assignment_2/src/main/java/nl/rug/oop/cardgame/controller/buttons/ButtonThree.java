package nl.rug.oop.cardgame.controller.buttons;

import nl.rug.oop.cardgame.controller.actions.ChooseActionThree;
import nl.rug.oop.cardgame.model.Game;

import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;

/**
 * Button that shuffles all cards into the deck. It uses the Action API to
 * perform its action which means that this is merely a default configuration
 * for this button.
 */
public class ButtonThree extends JButton {

    /**
     * Initialise the properties of this button
     */
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Choose option number three");
    }

    /**
     * Create an option three button
     *
     * @param game The actual game, passed to the controllers
     */
    public ButtonThree(Game game) {
        super(new ChooseActionThree(game));
        setButtonProperties();
    }

}

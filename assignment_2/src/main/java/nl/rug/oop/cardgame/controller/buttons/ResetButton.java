package cardgame.controller.buttons;

import cardgame.controller.actions.ResetAction;
import cardgame.model.DrawGame;

import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;

/**
 * Button that shuffles all cards into the deck. It uses the Action API to
 * perform its action which means that this is merely a default configuration
 * for this button.
 */
public class ResetButton extends JButton {

    /**
     * Initialise the properties of this button
     */
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Shuffle all cards back into the deck");
    }

    /**
     * Create a draw button
     *
     * @param drawGame The actual game, passed to the controllers
     */
    public ResetButton(DrawGame drawGame) {
        super(new ResetAction(drawGame));
        setButtonProperties();
    }

}

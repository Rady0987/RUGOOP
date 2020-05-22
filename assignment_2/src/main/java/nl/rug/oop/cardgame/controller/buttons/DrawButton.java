package cardgame.controller.buttons;

import cardgame.controller.actions.DrawAction;
import cardgame.model.DrawGame;

import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;

/**
 * Button that draws a card. It uses the Action API to perform its action
 * which means that this is merely a default configuration for this button.
 */
public class DrawButton extends JButton {

    /**
     * Initialise the properties of this button
     */
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_D);
        setToolTipText("Draw a card");
    }

    /**
     * Create a draw button
     *
     * @param drawGame The actual game, passed to the controllers
     */
    public DrawButton(DrawGame drawGame) {
        super(new DrawAction(drawGame));
        setButtonProperties();
    }

}

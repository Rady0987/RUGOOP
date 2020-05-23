package nl.rug.oop.cardgame.controller.buttons;


import nl.rug.oop.cardgame.controller.actions.DrawAction;
import nl.rug.oop.cardgame.model.Game;
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
     * @param game The actual game, passed to the controllers
     */
    public DrawButton(Game game) {
        super(new DrawAction(game));
        setButtonProperties();
    }

}

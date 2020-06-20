package nl.rug.oop.grapheditor.controller.buttons;

import nl.rug.oop.grapheditor.controller.actions.ChooseActionOne;
import nl.rug.oop.grapheditor.model.GraphModel;

import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;

/**
 * Button that does nothing yet
 */
public class ButtonOne extends JButton {

    /**
     * Initialise the properties of this button
     */
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Add a node");
    }

    /**
     * Create an option one button
     *
     * @param graph The graph, passed to the controllers
     */
    public ButtonOne(GraphModel graph) {
        super(new ChooseActionOne(graph));
        setButtonProperties();
    }

}

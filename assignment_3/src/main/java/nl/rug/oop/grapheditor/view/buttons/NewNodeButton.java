package nl.rug.oop.grapheditor.view.buttons;

import nl.rug.oop.grapheditor.controller.actions.NewNodeAction;
import nl.rug.oop.grapheditor.model.GraphModel;

import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;

/**
 * This class creates a button that makes a new node.
 */
public class NewNodeButton extends JButton {

    /**
     * The constructor.
     *
     * @param graph The graphModel.
     */
    public NewNodeButton(GraphModel graph) {
        super(new NewNodeAction(graph));
        setButtonProperties();
    }

    /**
     * This method sets the properties of the button.
     */
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Adds a node");
    }



}

package nl.rug.oop.grapheditor.view.buttons;

import nl.rug.oop.grapheditor.controller.actions.*;
import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * This class creates a button that removes a node.
 */
public class RemoveNodeButton extends JButton{

   /**
    * The constructor.
    *
    * @param graph The graphModel.
    */
   public RemoveNodeButton(GraphModel graph) {
      super(new RemoveNodeAction(graph));
      setButtonProperties();
   }

   /**
    * This method sets the properties of the button.
    */
   private void setButtonProperties() {
      setVerticalTextPosition(AbstractButton.CENTER);
      setHorizontalTextPosition(AbstractButton.CENTER);
      setMnemonic(KeyEvent.VK_S);
      setToolTipText("Select the node you want to remove, then click this button");
   }

}

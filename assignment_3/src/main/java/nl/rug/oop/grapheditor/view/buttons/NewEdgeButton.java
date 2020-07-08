package nl.rug.oop.grapheditor.view.buttons;

import nl.rug.oop.grapheditor.controller.actions.*;
import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * This class creates a button that makes a new edge.
 */
public class NewEdgeButton extends JButton{

   /**
    * The constructor.
    *
    * @param graph The graphModel.
    */
   public NewEdgeButton(GraphModel graph) {
      super(new NewEdgeAction(graph));
      setButtonProperties();
   }

   /**
    * This method sets the properties of the button.
    */
   private void setButtonProperties() {
      setVerticalTextPosition(AbstractButton.CENTER);
      setHorizontalTextPosition(AbstractButton.CENTER);
      setMnemonic(KeyEvent.VK_S);
      setToolTipText("Select the first node, then press this button");

   }
}

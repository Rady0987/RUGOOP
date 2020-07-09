package nl.rug.oop.grapheditor.view.buttons;

import nl.rug.oop.grapheditor.controller.actions.*;
import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * This class creates a button that removes an edge.
 */
public class RemoveEdgeButton extends JButton {

   /**
    * The constructor.
    *
    * @param graph The graphModel.
    */
   public RemoveEdgeButton(GraphModel graph) {
      super(new RemoveEdgeAction(graph));
      setButtonProperties();
   }

   /**
    * This method sets the properties of the button.
    */
   private void setButtonProperties() {
      setVerticalTextPosition(AbstractButton.CENTER);
      setHorizontalTextPosition(AbstractButton.CENTER);
      setMnemonic(KeyEvent.VK_S);
      setToolTipText("Select the two nodes that are connected by the edge you want to delete");
   }
}

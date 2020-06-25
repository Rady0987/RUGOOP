package nl.rug.oop.grapheditor.controller.buttons;

import nl.rug.oop.grapheditor.controller.actions.*;
import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Class of the ButtonFour
 */
public class ButtonFour extends JButton{

   /**
    * Initialise the properties of this button
    */
   private void setButtonProperties() {
      setVerticalTextPosition(AbstractButton.CENTER);
      setHorizontalTextPosition(AbstractButton.CENTER);
      setMnemonic(KeyEvent.VK_S);
      setToolTipText("Select a node first, click this button and select the second node that is connected by the edge you want to delete");
   }

   /**
    * Create an option four button
    *
    * @param graph The graph, passed to the controllers
    */
   public ButtonFour(GraphModel graph) {
      super(new ChooseActionFour(graph));
      setButtonProperties();
   }
}

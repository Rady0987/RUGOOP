package nl.rug.oop.grapheditor.controller.buttons;

import nl.rug.oop.grapheditor.controller.actions.*;
import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Class of the ButtonThree
 */
public class ButtonThree extends JButton{

   /**
    * Initialise the properties of this button
    */
   private void setButtonProperties() {
      setVerticalTextPosition(AbstractButton.CENTER);
      setHorizontalTextPosition(AbstractButton.CENTER);
      setMnemonic(KeyEvent.VK_S);
      setToolTipText("Select the node you want to remove, then click this button");
   }

   /**
    * Create an option one button
    *
    * @param graph The graph, passed to the controllers
    */
   public ButtonThree(GraphModel graph) {
      super(new ChooseActionThree(graph));
      setButtonProperties();
   }
}

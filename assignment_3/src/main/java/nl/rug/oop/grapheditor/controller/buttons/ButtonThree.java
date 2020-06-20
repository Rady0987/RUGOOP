package nl.rug.oop.grapheditor.controller.buttons;

import nl.rug.oop.grapheditor.controller.actions.*;
import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ButtonThree extends JButton{

   /**
    * Initialise the properties of this button
    */
   private void setButtonProperties() {
      setVerticalTextPosition(AbstractButton.CENTER);
      setHorizontalTextPosition(AbstractButton.CENTER);
      setMnemonic(KeyEvent.VK_S);
      setToolTipText("Remove node");
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

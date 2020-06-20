package nl.rug.oop.grapheditor.controller.buttons;

import nl.rug.oop.grapheditor.controller.actions.*;
import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ButtonFour extends JButton{

   /**
    * Initialise the properties of this button
    */
   private void setButtonProperties() {
      setVerticalTextPosition(AbstractButton.CENTER);
      setHorizontalTextPosition(AbstractButton.CENTER);
      setMnemonic(KeyEvent.VK_S);
      setToolTipText("Remove an edge");
   }

   /**
    * Create an option one button
    *
    * @param graph The graph, passed to the controllers
    */
   public ButtonFour(GraphModel graph) {
      super(new ChooseActionFour(graph));
      setButtonProperties();
   }
}

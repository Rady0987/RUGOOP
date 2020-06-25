package nl.rug.oop.grapheditor.controller.buttons;

import nl.rug.oop.grapheditor.controller.actions.*;
import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Class of the ButtonOTwo
 */
public class ButtonTwo extends JButton{
   /**
    * Initialise the properties of this button
    */
   private void setButtonProperties() {
      setVerticalTextPosition(AbstractButton.CENTER);
      setHorizontalTextPosition(AbstractButton.CENTER);
      setMnemonic(KeyEvent.VK_S);
      setToolTipText("Select the first node, then press this button");

   }

   /**
    * Create an option one button
    *
    * @param graph The graph, passed to the controllers
    */
   public ButtonTwo(GraphModel graph) {
      super(new ChooseActionTwo(graph));
      setButtonProperties();
   }
}

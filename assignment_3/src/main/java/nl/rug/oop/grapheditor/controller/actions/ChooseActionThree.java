package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Class of remove node action
 */
public class ChooseActionThree extends AbstractAction {
   private GraphModel graph;

   /**
    * Constructor.
    * Creates an action to remove a node
    *
    * @param graph GraphModel
    */
   public ChooseActionThree(GraphModel graph) {
      super("Remove node");
      this.graph = graph;
   }

   /**
    * Calls the corresponding method from model
    *
    * @param e ActionEvent that is raised from the user action
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      graph.optionThreeChosen();
   }

}

package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
/**
 * Class of remove edge action
 */
public class ChooseActionFour extends AbstractAction {
   private GraphModel graph;

   /**
    * Constructor.
    * Creates an action to remove an edge
    *
    * @param graph The option one
    */
   public ChooseActionFour(GraphModel graph) {
      super("Remove edge");
      this.graph = graph;
   }

   /**
    * Calls the corresponding method from model
    *
    * @param e ActionEvent that is raised from the user action
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      graph.optionFourChosen();
   }
}

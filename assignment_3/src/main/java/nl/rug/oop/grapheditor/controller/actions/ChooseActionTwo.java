package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Class of new edge action
 */
public class ChooseActionTwo extends AbstractAction {

   private GraphModel graph;

   /**
    * Constructor.
    * Creates an action to make a new edge
    *
    * @param graph GraphModel
    */
   public ChooseActionTwo(GraphModel graph) {
      super("New edge");
      this.graph = graph;
   }

   /**
    * Calls the corresponding method from model
    *
    * @param e ActionEvent that is raised from the user action
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      graph.optionTwoChosen();
   }
}

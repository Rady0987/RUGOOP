package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * This class creates a new action that saves a graph.
 */
public class SaveGraphAction extends AbstractAction {
   private final GraphModel graph;

   /**
    * The Constructor.
    *
    * @param graph The GraphModel.
    */
   public SaveGraphAction(GraphModel graph) {
      super("New Graph");
      this.graph = graph;
   }

   /**
    * This method calls the corresponding method from model.
    *
    * @param e ActionEvent that is raised from the user action.
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      graph.saveGraph();
   }
}

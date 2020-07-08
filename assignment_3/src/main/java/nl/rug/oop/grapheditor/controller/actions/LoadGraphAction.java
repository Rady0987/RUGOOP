package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.view.Warning;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * This class creates a load graph action.
 */
public class LoadGraphAction extends AbstractAction {
   private GraphModel graph;

   /**
    * The constructor.
    *
    * @param graph The GraphModel.
    */
   public LoadGraphAction(GraphModel graph) {
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
      String message = "Would you like to save the graph before loading?";
      Warning saveWarning = new Warning(message, graph);
      saveWarning.saveWarning();
      graph.loadGraph();
   }
}

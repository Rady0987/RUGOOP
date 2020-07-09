package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.view.Warning;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * This class creates a new graph action.
 */
public class NewGraphAction extends AbstractAction {

   private final GraphModel graph;

   /**
    * The Constructor.
    *
    * @param graph The GraphModel.
    */
   public NewGraphAction(GraphModel graph) {
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
      String message = "Would you like to save the graph before creating a new one?";
      if(graph.isGraphBlank()) {
         Warning saveWarning = new Warning(message, graph);
         saveWarning.saveWarning();
      }
      graph.newGraph();
   }
}

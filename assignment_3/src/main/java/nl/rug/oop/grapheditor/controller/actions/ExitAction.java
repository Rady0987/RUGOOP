package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.view.Warning;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * This class creates an Exit action.
 */
public class ExitAction extends AbstractAction {
   private final GraphModel graph;

   /**
    * Constructor.
    *
    * @param graph The GraphModel.
    */
   public ExitAction(GraphModel graph) {
      super("Exit");
      this.graph = graph;
   }

   /**
    * This method calls the corresponding method from model.
    *
    * @param e ActionEvent that is raised from the user action.
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      String message = "Would you like to save the graph before exiting?";
      if(graph.isGraphBlank()) {
         Warning saveWarning = new Warning(message, graph);
         saveWarning.saveWarning();
      }
      System.exit(0);
   }
}

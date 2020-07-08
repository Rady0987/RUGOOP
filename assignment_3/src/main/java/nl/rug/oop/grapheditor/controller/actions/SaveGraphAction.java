package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveGraphAction extends AbstractAction {
   private final GraphModel graph;

   /**
    * Constructor.
    * Creates an action to make a new edge
    *
    * @param graph GraphModel
    */
   public SaveGraphAction(GraphModel graph) {
      super("New Graph");
      this.graph = graph;
   }

   /**
    * Calls the corresponding method from model
    *
    * @param e ActionEvent that is raised from the user action
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      graph.saveGraph();
   }
}

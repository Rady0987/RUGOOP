package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * This class creates a new Undo action.
 */
public class UndoAction extends AbstractAction {
   private final GraphModel graph;
   /**
    * The Constructor.
    *
    * @param graph The GraphModel.
    */
   public UndoAction(GraphModel graph) {
      super("Undo");
      this.graph = graph;
   }

   /**
    * This method calls the corresponding method from model.
    *
    * @param e ActionEvent that is raised from the user action.
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      graph.undo();
   }
}

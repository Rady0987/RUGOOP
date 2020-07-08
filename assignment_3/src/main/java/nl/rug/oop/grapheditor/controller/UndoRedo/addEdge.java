package nl.rug.oop.grapheditor.controller.UndoRedo;

import nl.rug.oop.grapheditor.model.Edge;
import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.undo.AbstractUndoableEdit;

/**
 * Class that creates a new undoable action to add an edge.
 */
public class addEdge extends AbstractUndoableEdit{
   private final GraphModel graph;
   private final Edge edge;

   /**
    * The constructor.
    *
    * @param graph The graph model.
    * @param edge The edge that is added.
    *
    */
   public addEdge(GraphModel graph, Edge edge) {
      this.graph = graph;
      this.edge = edge;
   }

   /**
    * This method Undoes the edit.
    */
   @Override
   public void undo() {
      super.undo();
      graph.removeEdge(edge);
   }

   /**
    * This method Redoes the edit.
    */
   @Override
   public void redo() {
      if (super.canRedo()) {
         super.redo();
      }
      graph.addEdge(edge);
   }
}

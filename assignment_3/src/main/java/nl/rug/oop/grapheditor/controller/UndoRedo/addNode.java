package nl.rug.oop.grapheditor.controller.UndoRedo;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.Node;
import javax.swing.undo.AbstractUndoableEdit;

/**
 * Class that creates a new undoable action to add a node.
 */
public class addNode extends AbstractUndoableEdit{
   private final GraphModel graph;
   private Node node;

   /**
    * The constructor.
    *
    * @param graph The graph model
    *
    */
   public addNode(GraphModel graph) {
      this.graph = graph;
   }

   /**
    * This method Undoes the edit.
    */
   @Override
   public void undo() {
      super.undo();
      graph.removeNode(node);
   }

   /**
    * This method Redoes the edit.
    */
   @Override
   public void redo() {
      if (super.canRedo()) {
         super.redo();
      }
      node = new Node();
      graph.addNode(node);
   }
}

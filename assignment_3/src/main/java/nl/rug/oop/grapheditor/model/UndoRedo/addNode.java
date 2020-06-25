package nl.rug.oop.grapheditor.model.UndoRedo;

import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.undo.AbstractUndoableEdit;

public class addNode extends AbstractUndoableEdit{
   private final GraphModel graph;
   private int index;

   /**
    * Constructor
    *
    * @param graph The graph model
    */
   public addNode(GraphModel graph) {
      this.graph = graph;
   }

   @Override
   public void undo() {
      super.undo();
      graph.removeNode(index);
   }

   @Override
   public void redo() {
      if (super.canRedo()) {
         super.redo();
      }
      graph.addNode("Node", 100,100,80,170);
   }
}

package nl.rug.oop.grapheditor.model.UndoRedo;

import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.undo.AbstractUndoableEdit;

public class addEdge extends AbstractUndoableEdit{
   private final GraphModel graph;
   private final int nodeOne;
   private final int nodeTwo;

   /**
    * The constructor.
    *
    * @param graph The graph model
    * @param nodeOne The node one that is linked by the edge.
    * @param nodeTwo The node two that is linked by the edge.
    */
   public addEdge(GraphModel graph, int nodeOne, int nodeTwo) {
      this.graph = graph;
      this.nodeOne = nodeOne;
      this.nodeTwo = nodeTwo;
   }


   @Override
   public void undo() {
      super.undo();
      graph.removeEdge(nodeOne, nodeTwo);
   }


   @Override
   public void redo() {
      if (super.canRedo()) {
         super.redo();
      }
      graph.addEdge(nodeOne, nodeTwo);
   }
}

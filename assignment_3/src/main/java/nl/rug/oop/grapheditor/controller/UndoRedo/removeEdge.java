package nl.rug.oop.grapheditor.controller.UndoRedo;

import nl.rug.oop.grapheditor.model.Edge;
import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.Node;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;

/**
 * Class that creates a new undoable action to remove an edge.
 */
public class removeEdge extends AbstractUndoableEdit{
   private final GraphModel graph;
   private final ArrayList<Edge> Edges;
   private final ArrayList<Node> Nodes;
   /**
    * The constructor
    *
    * @param graph The GraphModel
    * @param Edges Arraylist with edges
    */
   public removeEdge(GraphModel graph, ArrayList<Edge> Edges) {
      this.graph = graph;
      this.Edges = (ArrayList<Edge>) Edges.clone();
      this.Nodes = (ArrayList<Node>) graph.getSelectedNodes().clone();
   }

   /**
    * This method Undoes the edit.
    */
   @Override
   public void undo() throws CannotUndoException {
      super.undo();
      for (Edge edge : Edges) {
         if (!graph.getEdgeList().contains(edge)) {
            graph.addEdge(edge);
         }
      }
   }

   /**
    * This method Redoes the edit.
    */
   @Override
   public void redo() throws CannotRedoException {
      if (super.canRedo()) {
         super.redo();
      }
      graph.removeEdge(Nodes.get(1), Nodes.get(0));
   }

}

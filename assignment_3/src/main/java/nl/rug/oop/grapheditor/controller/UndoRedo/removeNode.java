package nl.rug.oop.grapheditor.controller.UndoRedo;

import nl.rug.oop.grapheditor.model.Edge;
import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.Node;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;

/**
 * Class that creates a new undoable action to remove a node.
 */
public class removeNode extends AbstractUndoableEdit{
   private final GraphModel graph;
   private final ArrayList<Node> Nodes;
   private final ArrayList<Edge> Edges;

   /**
    * The constructor.
    *
    * @param graph       The graphModel
    */
   public removeNode(GraphModel graph) {
      this.graph = graph;
      Nodes = (ArrayList<Node>) graph.getSelectedNodes().clone();
      Edges = new ArrayList<>();
      for (Node node : Nodes) {
         for (Edge edge : graph.getEdgeList()) {
            if (edge.isConnectedTo(node)) {
               if (!Edges.contains(edge)) {
                  Edges.add(edge);
               }
            }
         }
      }
   }

   /**
    * This method Undoes the edit.
    */
   @Override
   public void undo() throws CannotUndoException {
      super.undo();
      if (Nodes != null) {
         for (Node node : Nodes) {
            graph.addNode(node);
         }
         if (Edges != null) {
            for (Edge edge : Edges) {
               graph.addEdge(edge);
            }
         }
      }
   }

   /**
    * This method Redoes the edit.
    */
   @Override
   public void redo() throws CannotRedoException {
      if(super.canRedo()) {
         super.redo();
      }
      if (Nodes != null) {
         for (Node node : Nodes) {
            graph.removeNode(node);
         }
      }
   }
}

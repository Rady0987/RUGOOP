package nl.rug.oop.grapheditor.model.UndoRedo;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.view.DrawFrame;

import javax.swing.undo.UndoManager;

public class Handler {
   private final GraphModel graph;
   private final DrawFrame frame;
   private final UndoManager undoManager;

   public Handler(GraphModel graph, DrawFrame frame, UndoManager undoManager) {
      this.graph = graph;
      this.frame = frame;
      this.undoManager = undoManager;
   }

   public void addNode() {
      addNode addNode = new addNode(graph);
      undoManager.addEdit(addNode);
      addNode.redo();
   }

   /**
    * This function undoes the last action.
    */
   public void undo() {
      undoManager.undo();
   }

   /**
    * This function redoes the last action.
    */
   public void redo() {
      undoManager.redo();
   }

}

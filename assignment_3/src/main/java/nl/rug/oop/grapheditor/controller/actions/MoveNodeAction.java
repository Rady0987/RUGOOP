package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.Node;
import nl.rug.oop.grapheditor.model.UndoRedo.moveNode;
import javax.swing.undo.UndoManager;
import java.awt.*;

/**
 * This class creates a move node action.
 */
public class MoveNodeAction {
   private final GraphModel graph;
   private final Node node;
   private final Point oldCoordinates;

   /**
    * The Constructor.
    *
    * @param graph GraphModel
    */
   public MoveNodeAction(GraphModel graph, Node node, Point oldCoordinates) {
      this.graph = graph;
      this.node = node;
      this.oldCoordinates = oldCoordinates;
   }

   /**
    * This method calls the corresponding method from model.
    *
    */
   public void actionPerformed() {
      UndoManager undoManager = graph.getUndoManager();
      moveNode moveNodeEdit = new moveNode(node, oldCoordinates, node.getCoordinates());
      undoManager.addEdit(moveNodeEdit);
      moveNodeEdit.redo();
   }
}

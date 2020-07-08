package nl.rug.oop.grapheditor.controller.UndoRedo;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.Node;
import javax.swing.undo.AbstractUndoableEdit;
import java.awt.*;

/**
 * Class that creates a new undoable action to move a node.
 */
public class moveNode extends AbstractUndoableEdit {
   private final GraphModel graph;
   private final Node node;
   private final Point oldCoordinates;
   private final Point newCoordinates;

   /**
    * The constructor.
    *
    * @param graph       The graphModel
    * @param node        The node that is moved
    * @param oldCoordinates The old coordinates of the node
    * @param newCoordinates The new coordinates of the node
    */
   public moveNode(GraphModel graph, Node node, Point oldCoordinates, Point newCoordinates) {
      this.graph = graph;
      this.node = node;
      this.oldCoordinates = (Point) oldCoordinates.clone();
      this.newCoordinates = (Point) newCoordinates.clone();
   }

   /**
    * This method Undoes the edit.
    */
   @Override
   public void undo() {
      super.undo();
      node.setY(oldCoordinates.y);
      node.setX(oldCoordinates.x);
   }

   /**
    * This method Redoes the edit.
    */
   @Override
   public void redo() {
      if (super.canRedo()) {
         super.redo();
      }
      node.setY(newCoordinates.y);
      node.setX(newCoordinates.x);
   }
}

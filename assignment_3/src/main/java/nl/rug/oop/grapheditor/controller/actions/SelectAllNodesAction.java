package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.Node;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * This class creates a new action that renames a node.
 */
public class SelectAllNodesAction extends AbstractAction {
      private final GraphModel graph;

      /**
       * The Constructor.
       *
       * @param graph The graphModel.
       */
      public SelectAllNodesAction(GraphModel graph) {
         super("Select all nodes");
         this.graph = graph;
      }

      /**
       * This method calls the corresponding method from model.
       *
       * @param e ActionEvent that is raised from the user action.
       */
      @Override
      public void actionPerformed(ActionEvent e) {
         for(Node node : graph.getNodeList())  {
            graph.setNodeSelected(node);
         }
      }
}

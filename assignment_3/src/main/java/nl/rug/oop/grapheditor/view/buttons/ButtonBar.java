package nl.rug.oop.grapheditor.view.buttons;

import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * This class creates four buttons with basic functionality.
 */
public class ButtonBar extends JPanel implements Observer {
   private final GraphModel graph;
   private final JButton removeNode;
   private final JButton removeEdge;
   private final JButton newEdge;

   /**
    * The Constructor.
    *
    * @param graph The graphModel.
    * @param buttonPanel The JPanel to which the bar is added.
    */
   public ButtonBar(GraphModel graph, JPanel buttonPanel){
      this.graph = graph;
      setLayout(new BorderLayout());
      buttonPanel.setLayout(new FlowLayout());
      buttonPanel.add(new NewNodeButton(graph));
      removeNode = new RemoveNodeButton(graph);
      removeNode.setEnabled(false);
      buttonPanel.add(removeNode);
      newEdge = new NewEdgeButton(graph);
      newEdge.setEnabled(false);
      buttonPanel.add(newEdge);
      removeEdge = new RemoveEdgeButton(graph);
      removeEdge.setEnabled(false);
      buttonPanel.add(removeEdge);
   }

   /**
    * This method change the state of the buttons according to the model.
    */
   public void updateState() {
      removeNode.setEnabled(graph.getSelectedNodes().size() != 0);
      removeEdge.setEnabled(graph.getEdgeList().size() > 0 && graph.getSelectedNodes().size() == 2 && graph.selectedNodesConnected());
      newEdge.setEnabled(graph.getSelectedNodes().size() == 1 && graph.getNodeList().size() >= 2);
   }

   /**
    * This method updates the state of the buttons.
    * @param o The source of the update call.
    * @param arg Argument.
    */
   @Override
   public void update(Observable o, Object arg) {
      updateState();
   }
}

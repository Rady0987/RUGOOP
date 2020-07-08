package nl.rug.oop.grapheditor.model;
import nl.rug.oop.grapheditor.controller.SelectionController;
import nl.rug.oop.grapheditor.model.IO.Saveload;

import javax.swing.undo.UndoManager;
import java.util.*;

/**
 * This class creates a new model of the graph editor.
 */
public class GraphModel extends Observable  {
   private static ArrayList<Node> Nodes;
   private static ArrayList<Edge> Edges;
   private static ArrayList<Node> selectedNodes;
   private final UndoManager undoManager;

   /**
    * The constructor.
    *
    */
   public GraphModel() {
      Nodes = new ArrayList<>();
      Edges = new ArrayList<>();
      selectedNodes = new ArrayList<>();
      undoManager = new UndoManager();
   }

   /**
    * This method removes an edge.
    *
    * @param nodeOne The first node.
    * @param nodeTwo the second node
    *
    */
   public void removeEdge(Node nodeOne, Node nodeTwo) {
      Edges.removeIf((edge) -> edge.getNodeOne() == nodeOne && edge.getNodeTwo() == nodeTwo ||
              edge.getNodeOne() == nodeTwo && edge.getNodeTwo() == nodeOne);
      setSelectedNodeNull();
      update();
   }

   public void removeEdge(Edge edge) {
      Edges.remove(edge);
      setSelectedNodeNull();
      update();
   }

   /**
    * This method adds a new edge.
    *
    * @param edge The edge itself.
    *
    */
   public void addEdge(Edge edge) {
      boolean ok = true;
      if (edge != null) {
         for(Edge i : Edges) {
            if(edge.sameEdges(i))
               ok = false;
         }
         if(ok)
            Edges.add(edge);
      }
      update();
      SelectionController.setNewEdge(false);
   }

   /**
    * This method adds a new node.
    *
    * @param node The node itself.
    *
    */
   public void addNode(Node node) {
      Nodes.add(node);
      setSelectedNodeNull();
      update();
   }

   /**
    * This method removes a specific node.
    *
    * @param node The node itself.
    *
    */
   public void removeNode(Node node) {
      Edges.removeIf((edge) -> edge.getNodeOne() == node || edge.getNodeTwo() == node);
      Nodes.remove(node);
      setSelectedNodeNull();
      update();
   }

   /**
    * This method creates a blank graph.
    *
    */
   public void newGraph() {
      Edges.removeAll(Edges);
      Nodes.removeAll(Nodes);
      undoManager.discardAllEdits();
      update();
   }

   /**
    * This method saves a graph.
    *
    */
   public void saveGraph() {
      Saveload.saveGraph(Edges, Nodes);
   }

   /**
    * This method loads a save of a graph.
    *
    */
   public void loadGraph() {
      newGraph();
      Saveload.loadGraph(this,"",false);
      update();
   }

   /**
    * This method gets a specific node.
    *
    * @param index index of the node
    * @return node itself
    */
   public Node getNode(int index) {
      return Nodes.get(index);
   }

   /**
    * This method notifies the observers that the model has changed.
    *
    */
    public void update() {
        setChanged();
        notifyObservers();
    }

   /**
    * This method returns the ArrayList of the Nodes.
    *
    * @return Nodes array.
    */
   public ArrayList<Node> getNodeList() {
      return Nodes;
   }

   /**
    * This method resets the selected nodes.
    *
    */
   public void setSelectedNodeNull() {
      for(Node node : Nodes) {
         node.setSelected(false);
      }
      selectedNodes.removeAll(selectedNodes);
      update();
   }

   /**
    * This method returns the ArrayList of the Edges.
    *
    * @return Edges array.
    */
   public ArrayList<Edge> getEdgeList() {
      return Edges;
   }

   /**
    * This method makes a specific node selected.
    *
    * @param node The node itself.
    */
   public void setNodeSelected(Node node) {
      selectedNodes.add(node);
      node.setSelected(true);
      update();
   }

   /**
    * This method makes a specific node unselected.
    *
    * @param node The node itself.
    */
   public void setNodeUnselected(Node node) {
      node.setSelected(false);
      selectedNodes.remove(node);
      update();
   }

   /**
    * This method returns the ArrayList of the selectedNodes.
    *
    * @return selectedNodes array.
    */
   public ArrayList<Node> getSelectedNodes() {
      return selectedNodes;
   }

   /**
    * This method returns the UndoManager.
    *
    * @return The UndoManager.
    */
   public UndoManager getUndoManager() {
      return undoManager;
   }

   /**
    * This method undoes an action and updates the state of the model.
    */
   public void undo() {
      if (undoManager.canUndo()) {
         undoManager.undo();
      }
      update();
   }

   /**
    * This method redoes an action and updates the state of the model.
    */
   public void redo() {
      if (undoManager.canRedo()) {
         undoManager.redo();
      }
      update();
   }

   /**
    * This method renames a node updates the state of the model.
    *
    * @param node The node itself.
    * @param name The new name of the node.
    */
   public void renameNode(Node node, String name) {
      node.rename(name);
      update();
   }
}
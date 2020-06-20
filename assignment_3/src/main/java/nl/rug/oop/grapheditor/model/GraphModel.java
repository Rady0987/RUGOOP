package nl.rug.oop.grapheditor.model;

import nl.rug.oop.grapheditor.controller.SelectionController;
import nl.rug.oop.grapheditor.model.IO.Saveload;

import java.util.*;

public class GraphModel extends Observable implements Observer {
   private static ArrayList<Node> Nodes;
   private static ArrayList<Edge> Edges;

   public GraphModel() {
      Nodes = new ArrayList<Node>();
      Edges = new ArrayList<Edge>();
      Saveload.loadGraph();

   }

   public void removeEdge(int index) {
      Edges.remove(index);
   }

   public static void addEdge(int nodeOne, int nodeTwo) {
      Edge edge = new Edge(nodeOne, nodeTwo);
      Edges.add(edge);
   }


   public static void addNode(String name, int x, int y, int height, int width) {
      Node node = new Node(name, x, y, width, height);
      Nodes.add(node);
      //node.printName();
   }

   public void removeNode(int index) {
      Nodes.remove(index);
      for (Edge i : Edges) {
         if (i.getNodeOne() == index || i.getNodeTwo() == index)
            Edges.remove(i);
      }
   }

   public void save() {
      Saveload.saveGraph(Edges, Nodes);
   }

   public Node getNode(int index){
      return Nodes.get(index);
   }

   public int getNodeListSize(){
      return Nodes.size();
   }

   public Edge getEdge(int index){
      return Edges.get(index);
   }

   public int getEdgeListSize(){
      return Edges.size();
   }

   public void optionOneChosen(){
      addNode("Node", 100,300,100,200);
      setChanged();
      notifyObservers();
   }

   public void optionTwoChosen(){

      setChanged();
      notifyObservers();
   }

   public void optionThreeChosen(){
      removeNode(SelectionController.getSelectedNode());
      setChanged();
      notifyObservers();
   }

   public void optionFourChosen(){
      //removeEdge();
      setChanged();
      notifyObservers();
   }
   /**
     * Updates the view
   */
    @Override
    public void update(Observable observable, Object message) {
        setChanged();
        notifyObservers();
    }


}
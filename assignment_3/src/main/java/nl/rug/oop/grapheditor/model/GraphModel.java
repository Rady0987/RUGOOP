package nl.rug.oop.grapheditor.model;

import nl.rug.oop.grapheditor.controller.SelectionController;
import nl.rug.oop.grapheditor.model.IO.Saveload;

import java.util.*;

public class GraphModel extends Observable implements Observer {
   private static ArrayList<Node> Nodes;
   private static ArrayList<Edge> Edges;

   public GraphModel() {
      Nodes = new ArrayList<>();
      Edges = new ArrayList<>();
   }

   public void removeEdge(int index) {
      Edges.remove(index);
   }

   public static void addEdge(int nodeOne, int nodeTwo) {
      Edge edge = new Edge(nodeOne, nodeTwo);
      Edges.add(edge);
      System.out.println("plus 1 edge");
   }


   public static void addNode(String name, int x, int y, int height, int width) {
      Node node = new Node(name, x, y, width, height);
      Nodes.add(node);

   }

   public void removeNode(int index) {
      Nodes.remove(index);
      for (int i = 0;  i < Edges.size(); i++) {
         if (Edges.get(i).getNodeOne() == index || Edges.get(i).getNodeTwo() == index)
            Edges.remove(i);
      }
      for (Edge i : Edges) {
         if (i.getNodeOne() > index)
            i.decNodeOneIndex();
         if (i.getNodeTwo() > index)
            i.decNodeTwoIndex();
      }
   }

   public void newGraph() {
      Saveload.saveGraph(Edges, Nodes);
      for(int i = Edges.size() - 1;  i >= 0; i--) {
         Edges.remove(i);
      }
      for(int i =Nodes.size() - 1;  i >= 0; i--) {
         Nodes.remove(i);
      }
      setChanged();
      notifyObservers();
   }

   public void saveGraph() {
      Saveload.saveGraph(Edges, Nodes);
   }

   public void loadGraph() {
      Saveload.loadGraph();
      setChanged();
      notifyObservers();
   }

   public void exit() {
      Saveload.saveGraph(Edges, Nodes);
      System.exit(0);
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
      //addEdge();
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

   public void move(int index, int x, int y) {
      Nodes.get(index).setX(x);
      Nodes.get(index).setY(y);

      /* Let the Observers know that the position of the Box has changed, which will update the View */
      setChanged();
      notifyObservers();
   }

}
package nl.rug.oop.grapheditor.model;

import java.util.ArrayList;

public class GraphModel {
   private ArrayList<Node> Nodes;
   private ArrayList<Edge> Edges;


   public void removeEdge(int index) {
      Edges.remove(index);
   }

   public void addEdge(int nodeOne, int nodeTwo) {
      Edge edge = new Edge(nodeOne, nodeTwo);
      Edges.add(edge);
   }

   public void addNode() {
      Node node = new Node();
      Nodes.add(node);
   }

   public void removeNode(int index) {
      Nodes.remove(index);
      for (Edge i : Edges) {
         if (i.getNodeOne() == index || i.getNodeTwo() == index)
            Edges.remove(i);
      }
   }
}
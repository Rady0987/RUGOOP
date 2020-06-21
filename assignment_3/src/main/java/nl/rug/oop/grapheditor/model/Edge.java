package nl.rug.oop.grapheditor.model;

public class Edge {
   private int nodeOne;
   private int nodeTwo;

   public Edge(int nodeOne, int nodeTwo) {
      this.nodeOne = nodeOne;
      this.nodeTwo = nodeTwo;
   }

   public int getNodeOne() {
      return nodeOne;
   }

   public int getNodeTwo() {
      return nodeTwo;
   }

   public void decNodeOneIndex() {
      nodeOne--;
   }

   public void decNodeTwoIndex() {
      nodeTwo--;
   }
}

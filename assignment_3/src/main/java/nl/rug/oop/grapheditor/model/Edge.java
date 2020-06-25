package nl.rug.oop.grapheditor.model;

/**
 * Edge class
 */
public class Edge {
   private int nodeOne;
   private int nodeTwo;

   /**
    * Constructor
    *
    * @param nodeOne the first node connected
    * @param nodeTwo the second node connected
    */
   public Edge(int nodeOne, int nodeTwo) {
      this.nodeOne = nodeOne;
      this.nodeTwo = nodeTwo;
   }

   /**
    * Getter for the node one
    *
    * @return nodeOne the first node
    */
   public int getNodeOne() {
      return nodeOne;
   }

   /**
    * Getter for the node two
    *
    * @return  nodeTwo the second node
    */
   public int getNodeTwo() {
      return nodeTwo;
   }

   /**
    * Method that subtracts 1 from node one index
    *
    */
   public void decNodeOneIndex() {
      nodeOne--;
   }

   /**
    * Method that subtracts 1 from node two index
    *
    */
   public void decNodeTwoIndex() {
      nodeTwo--;
   }
}

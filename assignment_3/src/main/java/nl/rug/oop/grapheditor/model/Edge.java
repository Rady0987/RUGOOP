package nl.rug.oop.grapheditor.model;

/**
 * Edge class
 */
public class Edge {
   private Node nodeOne;
   private Node nodeTwo;
   private boolean isSelected;

   /**
    * Constructor
    *
    * @param nodeOne the first node connected
    * @param nodeTwo the second node connected
    */
   public Edge(Node nodeOne, Node nodeTwo) {
      this.nodeOne = nodeOne;
      this.nodeTwo = nodeTwo;
      isSelected = false;
   }

   /**
    * Getter for the node one
    *
    * @return nodeOne the first node
    */
   public Node getNodeOne() {
      return nodeOne;
   }

   /**
    * Getter for the node two
    *
    * @return  nodeTwo the second node
    */
   public Node getNodeTwo() {
      return nodeTwo;
   }

   public boolean isConnectedTo(Node node) {
      return (nodeOne == node || nodeTwo == node);
   }

   public boolean sameEdges(Edge edge) {
      return((this.nodeOne == edge.nodeOne && this.nodeTwo == edge.nodeTwo) ||
              (this.nodeTwo == edge.nodeOne && this.nodeOne == edge.nodeTwo));
   }
}

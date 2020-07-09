package nl.rug.oop.grapheditor.model;

/**
 * This class creates a new edge.
 */
public class Edge {
   private final Node nodeOne;
   private final Node nodeTwo;

   /**
    * The Constructor.
    *
    * @param nodeOne The first node connected.
    * @param nodeTwo The second node connected.
    */
   public Edge(Node nodeOne, Node nodeTwo) {
      this.nodeOne = nodeOne;
      this.nodeTwo = nodeTwo;
   }

   /**
    * This method gets the first node.
    *
    * @return nodeOne the first node
    */
   public Node getNodeOne() {
      return nodeOne;
   }

   /**
    * This method gets the second node.
    *
    * @return nodeOne the second node
    */
   public Node getNodeTwo() {
      return nodeTwo;
   }

   /**
    * This method returns true if an edge is connected to a node.
    *
    * @param node The node.
    * @return A boolean value.
    */
   public boolean isConnectedTo(Node node) {
      return (nodeOne == node || nodeTwo == node);
   }

   /**
    * This method returns true if an edge is the same as an existing one.
    *
    * @param edge The edge.
    * @return A boolean value.
    */
   public boolean sameEdges(Edge edge) {
      return((this.nodeOne == edge.nodeOne && this.nodeTwo == edge.nodeTwo) ||
              (this.nodeTwo == edge.nodeOne && this.nodeOne == edge.nodeTwo));
   }
}

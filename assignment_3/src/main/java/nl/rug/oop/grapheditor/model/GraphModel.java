package nl.rug.oop.grapheditor.model;
import nl.rug.oop.grapheditor.model.IO.Saveload;
import java.util.*;

/**
 * GraphModel class
 */
public class GraphModel extends Observable  {
   private static ArrayList<Node> Nodes;
   private static ArrayList<Edge> Edges;
   private int selectedNode;
   private int firstSelectedNode;
   private int mouseX;
   private int mouseY;
   private boolean addEdgeButton;
   private boolean removeEdgeButton;
   private boolean renameButton;

   /**
    * Constructor
    *
    */
   public GraphModel() {
      Nodes = new ArrayList<>();
      Edges = new ArrayList<>();

   }

   /**
    * Method for removing an edge
    *
    * @param node1 the first node
    * @param node2 the second node
    *
    */
   public void removeEdge(int node1, int node2) {
      Edges.removeIf((edge) -> edge.getNodeOne() == node1 && edge.getNodeTwo() == node2 ||
              edge.getNodeOne() == node2 && edge.getNodeTwo() == node1);
   }

   /**
    * Method for adding an edge
    *
    * @param nodeOne the first node
    * @param nodeOne the second node
    *
    */
   public void addEdge(int nodeOne, int nodeTwo) {
      System.out.println("nodeone: "+nodeOne +" nodetwo: " + nodeTwo);
      Edge edge = new Edge(nodeOne, nodeTwo);
      Edges.add(edge);
      resetSelection();
   }

   /**
    * Method for adding a node
    *
    * @param name name of the node
    * @param x x coordonate
    * @param y y coordonate
    * @param height height
    * @param width width
    *
    */
   public void addNode(String name, int x, int y, int height, int width) {
      Node node = new Node(name, x, y, width, height);
      Nodes.add(node);
      resetSelection();
   }

   /**
    * Method for removing a node
    *
    * @param index index of the node
    *
    */
   public void removeNode(int index) {
      Edges.removeIf((edge) -> edge.getNodeOne() == index || edge.getNodeTwo() == index);
      for (Edge i : Edges) {
         if (i.getNodeOne() > index)
            i.decNodeOneIndex();
         if (i.getNodeTwo() > index)
            i.decNodeTwoIndex();
      }
      Nodes.remove(index);
      resetSelection();
      update();
   }

   /**
    * Method for creating a new page
    *
    */
   public void newGraph() {
      Saveload.saveGraph(Edges, Nodes, "Would you like to save?");
      Edges.removeAll(Edges);
      Nodes.removeAll(Nodes);
      resetSelection();
      update();
   }

   /**
    * Method for saving a graph
    *
    */
   public void saveGraph() {
      Saveload.saveGraph(Edges, Nodes,"Save");
   }

   /**
    * Method for loading a graph
    *
    */
   public void loadGraph() {
      Saveload.loadGraph(this,"",false);
      resetSelection();
      update();
   }

   /**
    * Method for exiting a graph
    *
    */
   public void exit() {
      Saveload.saveGraph(Edges, Nodes,"Would you like to save?");
      System.exit(0);
   }

   /**
    * Getter for a node
    *
    * @param index index of the node
    * @return node itself
    */
   public Node getNode(int index){
      return Nodes.get(index);
   }

   /**
    * Getter for an edge
    *
    * @param index index of the edge
    * @return edge itself
    */
   public Edge getEdge(int index){
      return Edges.get(index);
   }

   /**
    * Getter for the size of the node array
    *
    * @return size of the array
    */
   public int getNodeListSize(){
      return Nodes.size();
   }

   /**
    * Getter for the size of the edge array
    *
    * @return size of the array
    */
   public int getEdgeListSize(){
      return Edges.size();
   }


   /**
    * Method that corresponds to the Action one
    *
    */
   public void optionOneChosen(){
      addNode("Node", 100,100,80,170);
      update();
   }

   /**
    * Method that corresponds to the Action two
    *
    */
   public void optionTwoChosen(){
      firstSelectedNode = selectedNode;
      addEdgeButton = true;
      removeEdgeButton = false;
      selectedNode = -1;
      update();
   }

   /**
    * Method that corresponds to the Action three
    *
    */
   public void optionThreeChosen(){
      removeNode(selectedNode);
      update();
   }

   /**
    * Method that corresponds to the Action four
    *
    */
   public void optionFourChosen(){
      removeEdgeButton = true;
      addEdgeButton = false;
      firstSelectedNode = selectedNode;
      selectedNode = -1;
      update();
   }

   /**
    * Method that corresponds to the Action of rename button
    *
    */
   public void setRenameButton() {
      renameButton = true;
      update();
   }

   /**
     * Updates the view
   */
    public void update() {
        setChanged();
        notifyObservers();
    }

   /**
    * Method that changes the position of a node
    *
    * @param index index of the node
    * @param x x coordinate
    * @param y y coordinate
    */
   public void move(int index, int x, int y) {
      Nodes.get(index).setX(x);
      Nodes.get(index).setY(y);
      update();
   }

   /**
    * Method that handles the selected node
    *
    * @param index index of the node
    */
   public void setSelectedNode(int index) {
      selectedNode = index;
      if (addEdgeButton && firstSelectedNode != -1) {
         addEdge(firstSelectedNode, selectedNode);
         resetSelection();
      }

      if (removeEdgeButton && firstSelectedNode != -1 && Edges.size() > 0) {
         removeEdge(firstSelectedNode, selectedNode);
         resetSelection();
      }
      update();
   }

   /**
    * Getter for the selected node
    *
    * @return selectedNode
    */
   public int getSelectedNode() {
      return selectedNode;
   }

   /**
    * Setter for the mouse location
    *
    * @param x x coordinate
    * @param y y coordinate
    */
   public void setMouseLocation(int x, int y) {
      mouseX = x;
      mouseY = y;
      update();
   }

   /**
    * Getter that is true if addEdgeButton was pressed
    *
    * @return addEdgeButton
    */
   public boolean getaddEdgeButton() {
       return addEdgeButton;
   }

   /**
    * Getter for the first selected node
    *
    * @return firstSelectedNode
    */
   public int getFirstSelectedNode() {
       return firstSelectedNode;
   }

   /**
    * Getter for the X coordinate of the cursor
    *
    * @return mouseX
    */
   public int getMouseX() {
       return mouseX;
   }

   /**
    * Getter for the Y coordinate of the cursor
    *
    * @return mouseY
    */
   public int getMouseY() {
       return mouseY;
   }

   /**
    * Method that resets the selected node
    *
    */
   public void setSelectedNodeNull() {
      selectedNode = -1;
      update();
   }

   /**
    * Method that resets all the variables after a selection.
    */
   public void resetSelection() {
       selectedNode = -1;
       mouseY = 0;
       mouseX = 0;
       firstSelectedNode = -1;
       addEdgeButton = false;
       removeEdgeButton = false;
       update();
   }

   /**
    * Method that renames the node
    *
    * @param newName the new name of the node
    */
   public void renameSelectedNode(String newName) {
      System.out.println("sdadasdasdasd"+selectedNode);
      if (selectedNode >= 0 && selectedNode < Nodes.size()) {
         System.out.println("!!!!!");
         Nodes.get(selectedNode).setName(newName);
         setSelectedNodeNull();
         renameButton = false;
         update();
      }
   }

   /**
    * Getter if the rename button was presses
    *
    * @return renamebutton
    */
   public boolean isRenameButton() {
      return renameButton;
   }
}
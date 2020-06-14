package nl.rug.oop.grapheditor;

import nl.rug.oop.grapheditor.model.GraphModel;

public class GraphEditor {

   public static void main(String[] args) {
      GraphModel model = new GraphModel();
//      model.addNode("one");
//      model.addNode("two");
//      model.addNode("three");
//      model.addNode("four");
//      model.addEdge(0,1);
//      model.addEdge(1,2);
      model.saveGraph();
   }
}
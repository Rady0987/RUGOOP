package nl.rug.oop.grapheditor;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.IO.Saveload;
import nl.rug.oop.grapheditor.view.*;

public class GraphEditor {

   public static void main(String[] args) {
      GraphModel model = new GraphModel();
//      model.addNode("one");
//      model.addNode("two");
//      model.addNode("three");
//      model.addNode("four");
//      model.addEdge(0,1);
//      model.addEdge(1,2);
      /* Create the frame */
      new DrawFrame(model);
      model.save();
   }
}
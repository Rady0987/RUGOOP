package nl.rug.oop.grapheditor;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.view.*;
import static nl.rug.oop.grapheditor.model.IO.Saveload.loadGraph;

/**
 * GraphEditor class.
 */
public class GraphEditor {
   /**
    * Main method
    */
   public static void main(String[] args) {
      GraphModel model = new GraphModel();
      if (args.length == 3 && args[0].equals("java") && args[1].equals("GraphEditor")) {
         String file = args[2];
         loadGraph(model, file, true);
      }
      /* Create the frame */
      new DrawFrame(model);
   }
}
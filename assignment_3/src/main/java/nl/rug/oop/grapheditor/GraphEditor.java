package nl.rug.oop.grapheditor;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.view.*;
import static nl.rug.oop.grapheditor.model.IO.Saveload.loadGraph;

/**
 * This class creates the Graph Editor.
 */
public class GraphEditor {

   /**
    * This is the main method.
    */
   public static void main(String[] args) {
      GraphModel model = new GraphModel();
      /* If in the command-line there is only one argument (the path), the program will load it */
      if (args.length == 1) {
         String file = args[0];
         loadGraph(model, file, true);
      }
      /* Create the frame */
      new DrawFrame(model);
   }
}
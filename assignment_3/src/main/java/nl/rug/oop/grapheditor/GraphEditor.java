package nl.rug.oop.grapheditor;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.IO.Saveload;
import nl.rug.oop.grapheditor.view.*;

public class GraphEditor {

   public static void main(String[] args) {
      GraphModel model = new GraphModel();
      /* Create the frame */
      new DrawFrame(model);
   }
}
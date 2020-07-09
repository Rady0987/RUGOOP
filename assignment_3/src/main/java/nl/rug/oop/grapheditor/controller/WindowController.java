package nl.rug.oop.grapheditor.controller;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.view.Warning;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This class creates a new window controller of the graph editor frame.
 */
public class WindowController extends WindowAdapter {
   private final GraphModel graph;

   /**
    * Constructor.
    *
    * @param graph The GraphModel.
    */
   public WindowController(GraphModel graph) {
      this.graph = graph;
   }

   /**
    * This method does asks for saving when the frame is closed.
    *
    * @param event The WindowEvent.
    */
   @Override
   public void windowClosing(WindowEvent event) {
      String message = "Would you like to save the graph before exiting?";
      if(graph.isGraphBlank()) {
         Warning saveWarning = new Warning(message, graph);
         saveWarning.saveWarning();
      }
      System.exit(0);
   }
}

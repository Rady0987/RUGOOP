package nl.rug.oop.grapheditor.view;

import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;

/**
 * This class creates a warning depending on its purpose.
 */
public class Warning extends JOptionPane {
   private final String warning;
   private final GraphModel graph;

   /**
    * The Constructor.
    *
    * @param warning The message of the warning.
    * @param graph The GraphModel.
    */
   public Warning(String warning, GraphModel graph) {
      this.warning = warning;
      this.graph = graph;
   }

   /**
    * This method creates a confirming dialog.
    *
    */
   public void saveWarning() {
      int dialogResult = showConfirmDialog(null, warning, "Warning", JOptionPane.YES_NO_OPTION);
      if(dialogResult == JOptionPane.YES_OPTION)  {
         graph.saveGraph();
      }
   }
}

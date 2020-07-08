package nl.rug.oop.grapheditor.view;

import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;

/**
 *
 */
public class Warning extends JOptionPane {
   private String warning;
   private GraphModel graph;
   public Warning(String warning, GraphModel graph) {
      this.warning = warning;
      this.graph = graph;
   }

   public void saveWarning() {
      int dialogResult = showConfirmDialog(null, warning, "Warning", JOptionPane.YES_NO_OPTION);
      if(dialogResult == JOptionPane.YES_OPTION)  {
         graph.saveGraph();
      }
   }

   public void noEdgeWarning() {

   }
}

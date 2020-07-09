package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.view.DrawPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * This class creates a dark mode action.
 */
public class DarkModeAction extends AbstractAction {
   private final DrawPanel panel;

   /**
    * Constructor.
    *
    * @param panel The DrawPanel.
    */
   public DarkModeAction(DrawPanel panel) {
      super("Dark mode");
      this.panel = panel;
   }

   /**
    * This method calls the corresponding method from view.
    *
    * @param e ActionEvent that is raised from the user action.
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      panel.darkMode();
   }
}

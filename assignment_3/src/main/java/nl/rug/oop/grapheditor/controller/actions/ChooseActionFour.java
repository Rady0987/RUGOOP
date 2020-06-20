package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ChooseActionFour extends AbstractAction {
   private GraphModel graph;

   /**
    * Creates not an action yet
    *
    * @param graph The option one
    */
   public ChooseActionFour(GraphModel graph) {
      super("Remove edge");
      this.graph = graph;
   }

   /**
    * Not an action yet
    *
    * @param e ActionEvent that is raised from the user action
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      graph.optionFourChosen();
   }
}

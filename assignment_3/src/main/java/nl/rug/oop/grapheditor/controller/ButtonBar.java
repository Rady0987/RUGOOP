package nl.rug.oop.grapheditor.controller;

import nl.rug.oop.grapheditor.controller.buttons.*;
import nl.rug.oop.grapheditor.model.GraphModel;

import javax.swing.*;

/**
 * Panel with the buttons for the draw-class controllers
 */
public class ButtonBar extends JMenuBar {

    /**
     * Create a new ButtonBar with all the necessary buttons
     *
     * @param graph The graph, passed to the controllers
     */
    public ButtonBar(GraphModel graph) {
        add(new ButtonOne(graph));
        add(new ButtonTwo(graph));
        add(new ButtonThree(graph));
        add(new ButtonFour(graph));
//        JMenuBar menu = new JMenuBar();
//        JMenu file = new JMenu("File");
//        JMenuItem exit = new JMenuItem("Exit");
//        file.add(exit);
//        menu.add(file);
//        JMenu edit = new JMenu("Edit");
//        menu.add(edit);
    }

}

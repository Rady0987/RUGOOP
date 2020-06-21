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
        menus(graph);
        add(new ButtonOne(graph));
        add(new ButtonTwo(graph));
        add(new ButtonThree(graph));
        add(new ButtonFour(graph));
    }

    /**
     * Create 2 Jmenus with all the necessary buttons
     *
     * @param graph The graph, passed to the controllers
     */
    public void menus(GraphModel graph) {
        JMenu file = new JMenu("File");
        file.add(newButton(graph));
        file.add(openButton(graph));
        file.add(saveButton(graph));
        file.add(exitButton(graph));
        add(file);
        JMenu edit = new JMenu("Edit");
        edit.add(undoButton(graph));
        edit.add(redoButton(graph));
        add(edit);
    }

    /**
     * Create Newfile button
     *
     * @param graph The graph, passed to the controllers
     */
    public JMenuItem newButton(GraphModel graph) {
        JMenuItem newFile = new JMenuItem("New");
        newFile.addActionListener(e -> graph.newGraph());
        return newFile;
    }

    /**
     * Create OpenFile button
     *
     * @param graph The graph, passed to the controllers
     */
    public JMenuItem openButton(GraphModel graph) {
        JMenuItem loadFile = new JMenuItem("Load");
        loadFile.addActionListener(e -> graph.loadGraph());
        return loadFile;
    }

    /**
     * Create Exit button
     *
     * @param graph The graph, passed to the controllers
     */
    public JMenuItem exitButton(GraphModel graph) {
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> graph.exit());
        return exit;
    }

    /**
     * Create SaveFile button
     *
     * @param graph The graph, passed to the controllers
     */
    public JMenuItem saveButton(GraphModel graph) {
        JMenuItem saveFile = new JMenuItem("Save");
        saveFile.addActionListener(e -> graph.saveGraph());
        return saveFile;
    }

    /**
     * Create Undo button
     *
     * @param graph The graph, passed to the controllers
     */
    public JMenuItem undoButton(GraphModel graph) {
        JMenuItem undo = new JMenuItem("Undo");
        //undo.addActionListener(e -> );
        return undo;
    }

    /**
     * Create Redo button
     *
     * @param graph The graph, passed to the controllers
     */
    public JMenuItem redoButton(GraphModel graph) {
        JMenuItem redo = new JMenuItem("Redo");
        //redo.addActionListener(e -> );
        return redo;
    }

}

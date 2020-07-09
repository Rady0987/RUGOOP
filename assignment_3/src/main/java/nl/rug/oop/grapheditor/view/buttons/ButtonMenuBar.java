package nl.rug.oop.grapheditor.view.buttons;

import nl.rug.oop.grapheditor.controller.actions.*;
import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.view.DrawPanel;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * This class creates a bar with 2 menus: File, Edit.
 */
public class ButtonMenuBar extends JMenuBar implements Observer {
    private final JMenu edit;
    private final GraphModel graph;
    private final DrawPanel panel;
    private final JMenu view;

    /**
     * The Constructor.
     *
     * @param graph The graphModel.
     * @param panel The DrawPanel.
     */
    public ButtonMenuBar(GraphModel graph, DrawPanel panel) {
        this.graph = graph;
        this.panel = panel;
        JMenu file = new JMenu("File");
        JMenuItem newFile = new JMenuItem("New");
        newFile.addActionListener(new NewGraphAction(graph));
        newFile.setAccelerator(KeyStroke.getKeyStroke("control N"));
        file.add(newFile);
        JMenuItem loadFile = new JMenuItem("Load");
        loadFile.addActionListener(new LoadGraphAction(graph));
        file.add(loadFile);
        JMenuItem saveFile = new JMenuItem("Save");
        saveFile.setAccelerator(KeyStroke.getKeyStroke("control S"));
        saveFile.addActionListener(new SaveGraphAction(graph));
        file.add(saveFile);
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ExitAction(graph));
        file.add(exit);
        add(file);
        this.edit = new JMenu("Edit");
        JMenuItem rename = new JMenuItem("Rename");
        rename.addActionListener(new RenameNodeAction(graph));
        rename.setAccelerator(KeyStroke.getKeyStroke("control R"));
        rename.setEnabled(false);
        edit.add(rename);
        JMenuItem selectAll = new JMenuItem("Select all nodes");
        selectAll.addActionListener(new SelectAllNodesAction(graph));
        selectAll.setAccelerator(KeyStroke.getKeyStroke("control A"));
        selectAll.setEnabled(false);
        edit.add(selectAll);
        JMenuItem undo = new JMenuItem("Undo");
        undo.addActionListener(new UndoAction(graph));
        undo.setAccelerator(KeyStroke.getKeyStroke("control Z"));
        rename.setEnabled(false);
        edit.add(undo);
        JMenuItem redo = new JMenuItem("Redo");
        redo.setAccelerator(KeyStroke.getKeyStroke("control Y"));
        redo.addActionListener(new RedoAction(graph));
        rename.setEnabled(false);
        edit.add(redo);
        add(edit);
        view = new JMenu("View");
        JMenuItem darkMode = new JMenuItem("Dark mode");
        darkMode.addActionListener(new DarkModeAction(panel));
        view.add(darkMode);
        JMenuItem defaultMode = new JMenuItem("Default mode");
        defaultMode.addActionListener(new DefaultModeAction(panel));
        defaultMode.setEnabled(false);
        view.add(defaultMode);
        add(view);
    }

    /**
     * This method change the state of the buttons.
     */
    public void changeButtonState() {
        edit.getItem(0).setEnabled(graph.getSelectedNodes().size() == 1);
        edit.getItem(1).setEnabled(graph.getNodeList().size() > 0);
        edit.getItem(2).setEnabled(graph.getUndoManager().canUndo());
        edit.getItem(3).setEnabled(graph.getUndoManager().canRedo());
        view.getItem(0).setEnabled(panel.getBackground() == Color.white);
        view.getItem(1).setEnabled(panel.getBackground() == Color.darkGray);
    }

    /**
     * This method updates the state of the buttons.
     * @param o The source of the update call.
     * @param arg Argument.
     */
    @Override
    public void update(Observable o, Object arg) {
        changeButtonState();
    }
}

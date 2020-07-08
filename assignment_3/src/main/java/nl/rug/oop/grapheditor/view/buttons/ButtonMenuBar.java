package nl.rug.oop.grapheditor.view.buttons;

import nl.rug.oop.grapheditor.controller.actions.*;
import nl.rug.oop.grapheditor.view.buttons.*;
import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.view.buttons.NewEdgeButton;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * This class creates a bar with 2 menus: File, Edit.
 */
public class ButtonMenuBar extends JMenuBar implements Observer {
    private JMenu edit;
    private GraphModel graph;

    /**
     * The Constructor.
     *
     * @param graph The graphModel.
     */
    public ButtonMenuBar(GraphModel graph) {
        this.graph = graph;
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
    }

    /**
     * This method change the state of the buttons.
     */
    public void changeButtonState() {
        edit.getItem(0).setEnabled(graph.getSelectedNodes().size() == 1);
        edit.getItem(1).setEnabled(graph.getUndoManager().canUndo());
        edit.getItem(2).setEnabled(graph.getUndoManager().canRedo());
    }

    /**
     * This method updates the state of the buttons.
     * @param o The source of the update call.
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        changeButtonState();
    }
}

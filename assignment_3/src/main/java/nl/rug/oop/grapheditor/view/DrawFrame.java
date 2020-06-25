package nl.rug.oop.grapheditor.view;
import nl.rug.oop.grapheditor.controller.*;
import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.UndoRedo.Handler;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;

/**
 * DrawFrame class
 */
public class DrawFrame extends JFrame {

    public DrawFrame(GraphModel graph) {
        /* Create a frame for the GUI */
        super("Graph Editor ");
        UndoManager undoManager = new UndoManager();
        Handler handler = new Handler(graph, this, undoManager);
        /* Make sure our program exits when we close the frame */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Add a menu to the frame */
        setJMenuBar((new ButtonBar(graph, handler)));
        DrawPanel panel = new DrawPanel(graph);

        /* Create a controller for the mouse input */
        new SelectionController(graph, panel);
        /* Add the view to the frame */
        add(panel);
        /* Set the size of the frame */
        setPreferredSize(new Dimension(1300, 900));
        /* Try to make all the components at or above their preferred size */
        pack();
        /* Center the frame on the screen */
        setLocationRelativeTo(null);
        /* Make sure we can actually see the frame */
        setVisible(true);
    }
}

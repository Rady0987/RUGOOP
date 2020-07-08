package nl.rug.oop.grapheditor.view;
import nl.rug.oop.grapheditor.controller.*;
import nl.rug.oop.grapheditor.controller.WindowController;
import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.view.buttons.ButtonBar;
import nl.rug.oop.grapheditor.view.buttons.ButtonMenuBar;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * This class creates a new frame, part of the graph editor view.
 */
public class DrawFrame extends JFrame implements Observer {

    /**
     * The constructor.
     *
     * @param graph The GraphModel.
     */
    public DrawFrame(GraphModel graph) {
        /* Create a frame for the GUI */
        super("Graph Editor ");
        /* Make sure our program exits and asks for saving when we close the frame */
        addWindowListener(new WindowController(graph));
        /* Add a menu bar to the frame */
        ButtonMenuBar menuBar = new ButtonMenuBar(graph);
        graph.addObserver(menuBar);
        setJMenuBar(menuBar);
        /* Add a panel to the frame */
        DrawPanel panel = new DrawPanel(graph);
        /* Add a button bar to the panel */
        ButtonBar bar = new ButtonBar(graph, panel);
        add(bar, BorderLayout.NORTH);
        graph.addObserver(bar);
        /* Create a controller for the mouse input */
        new SelectionController(graph, panel);
        /* Add the view to the frame */
        add(panel);
        /* Set the size of the frame */
        setPreferredSize(new Dimension(1300, 900));
        setMinimumSize(new Dimension(860, 440));
        /* Try to make all the components at or above their preferred size */
        pack();
        /* Center the frame on the screen */
        setLocationRelativeTo(null);
        /* Make sure we can actually see the frame */
        setVisible(true);
    }

    /**
     * This method updates the state of the frame.
     * @param o The source of the update call.
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

}

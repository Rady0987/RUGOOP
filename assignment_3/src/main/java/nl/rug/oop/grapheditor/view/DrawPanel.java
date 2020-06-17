package nl.rug.oop.grapheditor.view;

import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

/**
 * View of Draw
 */
public class DrawPanel extends JPanel implements Observer {

    private GraphModel graph;

    /**
     * Create a new DrawPanel
     */
    public DrawPanel(GraphModel graph) {
        this.graph = graph;
        graph.addObserver(this);
        setBackground(Color.darkGray);
        setVisible(true);
        setOpaque(true);
    }

    /**
     * Paint the items that this class alone is responsible for.
     * <p>
     * This method is part of a template method that calls
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * Tell this DrawPanel that the object it displays has changed
     */
    @Override
    public void update(Observable observed, Object message) {
        repaint();
    }

}
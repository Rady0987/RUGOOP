package nl.rug.oop.grapheditor.view;
import nl.rug.oop.grapheditor.controller.SelectionController;
import nl.rug.oop.grapheditor.model.Edge;
import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Observer;
import java.util.Observable;

/**
 * This class creates a new panel, part of the graph editor view.
 */
public class DrawPanel extends JPanel implements Observer {

    private int startWidth = 1300;
    private int startHeight = 900;
    private GraphModel graph;
    private Point mouse;

    /**
     * Constructor
     *
     * @param graph The GraphModel.
     */
    public DrawPanel(GraphModel graph) {
        this.graph = graph;
        graph.addObserver(this);
        setBackground(Color.darkGray);
        setVisible(true);
        setOpaque(true);
    }

    /**
     * Method that paints the nodes
     *
     * @param g Graphics component
     */
    private void paintNodes(Graphics g) {
        for(Node node : graph.getNodeList()){
            g.setColor(Color.lightGray);
            if(node.isSelected()){
                g.setColor(Color.RED);
            }
            g.fillRect(node.x, node.y, node.width, node.height);
            g.setColor(Color.black);
            g.drawRect(node.x, node.y, node.width, node.height);
            int sizeText = 50;
            g.setFont (new Font ("Courier", Font.BOLD, sizeText));
            Rectangle2D textSize = g.getFontMetrics().getStringBounds(node.getName(), g);
            g.drawString(node.getName(), (int) (node.getCenter().x - textSize.getCenterX()), (int) (node.getCenter().y - textSize.getCenterY()));
        }
    }

    /**
     * Method that paints the edges
     *
     * @param g Graphics component
     */
    private void paintEdges(Graphics g) {
        g.setColor(Color.lightGray);
        for(Edge edge : graph.getEdgeList()){
            Point startNode = edge.getNodeOne().getCenter();
            Point endNode = edge.getNodeTwo().getCenter();
            g.drawLine(startNode.x, startNode.y, endNode.x, endNode.y);
        }
    }

    /**
     * Method that paints a new created edge
     *
     * @param g Graphics component
     */
    public void paintAddingEdge(Graphics g) {
        if (graph.getSelectedNodes().size() != 0 && SelectionController.isNewEdgePressed()) {
            Node node = graph.getSelectedNodes().get(0);
            g.setColor(new Color(135, 20, 100));
            Graphics2D g2D = (Graphics2D) g;
            g2D.setStroke(new BasicStroke(5.0F));
            Point startNode = node.getCenter();
            g.drawLine(startNode.x, startNode.y, mouse.x, mouse.y);
        }
    }

    /**
     * Paint the items that this class alone is responsible for.
     * <p>
     * This method is part of a template method that calls
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintAddingEdge(g);
        paintEdges(g);
        paintNodes(g);  
    }

    /**
     * Tell this DrawPanel that the object it displays has changed
     */
    @Override
    public void update(Observable observed, Object message) {
        repaint();
    }

    /**
     * Getter for the X coordonate in terms of the screen ratio
     */
    public double getRatioX(){
        return (double)getWidth()/startWidth;
    }

    /**
     * Getter for the Y coordonate in terms of the screen ratio
     */
    public double getRatioY(){
        return (double)getHeight()/startHeight;
    }

    public void setMousePosition(Point position) {
        mouse = position;
    }
}
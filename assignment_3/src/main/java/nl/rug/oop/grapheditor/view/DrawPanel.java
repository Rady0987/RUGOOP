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
    private final GraphModel graph;
    private Point mouse;
    private Color edgeColor = Color.blue;

    /**
     * The Constructor.
     *
     * @param graph The GraphModel.
     */
    public DrawPanel(GraphModel graph) {
        this.graph = graph;
        graph.addObserver(this);
        setBackground(Color.white);
        setVisible(true);
        setOpaque(true);
    }

    /**
     * This method paints the nodes.
     *
     * @param g Graphics component.
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
     * This method paints the edges.
     *
     * @param g Graphics component.
     */
    private void paintEdges(Graphics g) {
        g.setColor(edgeColor);
        for(Edge edge : graph.getEdgeList()){
            Point startNode = edge.getNodeOne().getCenter();
            Point endNode = edge.getNodeTwo().getCenter();
            g.drawLine(startNode.x, startNode.y, endNode.x, endNode.y);
        }
    }

    /**
     * This method paints a new created edge.
     *
     * @param g Graphics component.
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
     * This method change the color of the background and edges.
     *
     */
    public void darkMode() {
        this.setBackground(Color.darkGray);
        edgeColor = Color.RED;
        repaint();
    }

    /**
     * This method change the color of the background and edges to default one.
     *
     */
    public void defaultMode() {
        this.setBackground(Color.white);
        edgeColor = Color.blue;
        repaint();
    }

    /**
     * This method paints the items that this class alone is responsible for.
     *
     * @param g Graphics component.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintAddingEdge(g);
        paintEdges(g);
        paintNodes(g);  
    }

    /**
     * This method updates the state of the panel.
     *
     * @param observed The source of the update call.
     * @param message Argument.
     */
    @Override
    public void update(Observable observed, Object message) {
        repaint();
    }

    /**
     * This method updates the position of the cursor.
     *
     * @param position The point where the cursor is located.
     */
    public void setMousePosition(Point position) {
        mouse = position;
    }
}
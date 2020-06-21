package nl.rug.oop.grapheditor.view;

import nl.rug.oop.grapheditor.controller.SelectionController;
import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

/**
 * View of Draw
 */
public class DrawPanel extends JPanel implements Observer {

    private int startWidth = 1300;
    private int startHeight = 900;
    private GraphModel graph;
    private int nodeSelected;


    /**
     * Create a new DrawPanel
     */
    public DrawPanel(GraphModel graph) {
        this.graph = graph;
        graph.addObserver(this);
        setBackground(Color.darkGray);
        setVisible(true);
        setOpaque(true);
        nodeSelected = -1;
    }

    /**
     * Paint the nodes
     */
    private void paintNodes(Graphics g) {
        int sizeOfNodes = graph.getNodeListSize();
        for(int i = 0; i < sizeOfNodes; i++){  
            g.setColor(Color.lightGray);
            if(nodeSelected == i){
                g.setColor(Color.RED);
            }
            int xVal = (int) (graph.getNode(i).getX() * getRatioX());
            int yVal = (int) (graph.getNode(i).getY() * getRatioY());
            int widthVal = (int) (graph.getNode(i).getWidth() * getRatioX());
            int heightVal = (int)(graph.getNode(i).getHeight() * getRatioY());
            g.fillRect(xVal, yVal, widthVal, heightVal);
            g.setColor(Color.black);
            g.drawRect(xVal, yVal, widthVal, heightVal);
            int sizeText = 200;
            g.setFont (new Font ("Courier", Font.BOLD, sizeText));
            int width = g.getFontMetrics().stringWidth(graph.getNode(i).name);
            while(width > ((3 * widthVal)/4)){
                sizeText--;
                g.setFont(new Font ("Courier", Font.BOLD, sizeText));
                width = g.getFontMetrics().stringWidth(graph.getNode(i).name);  
            }
            g.drawString(graph.getNode(i).name, xVal + widthVal/8, yVal + heightVal/2);
        }
    }

    /**
     * Paint the nodes
     */
    private void paintEdges(Graphics g) {
        int sizeOfEdges = graph.getEdgeListSize();
        g.setColor(Color.lightGray);
        for(int i = 0; i < sizeOfEdges; i++){  
            int node1 = graph.getEdge(i).getNodeOne();
            int node2 = graph.getEdge(i).getNodeTwo();

            int x1 = graph.getNode(node1).getX() * getWidth()/startWidth;
            x1 += (graph.getNode(node1).getWidth() * getWidth()/startWidth)/2;
            int y1 = graph.getNode(node1).getY() * getHeight()/startHeight;
            y1 += (graph.getNode(node1).getHeight() * getHeight()/startHeight)/2;

            int x2 = graph.getNode(node2).getX() * getWidth()/startWidth;
            x2 += (graph.getNode(node2).getWidth() * getWidth()/startWidth)/2;
            int y2 = graph.getNode(node2).getY() * getHeight()/startHeight;
            y2 += (graph.getNode(node2).getHeight() * getHeight()/startHeight)/2;

            g.drawLine(x1, y1, x2, y2);
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

    public double getRatioX(){
        return (double)getWidth()/startWidth;
    }

    public double getRatioY(){
        return (double)getHeight()/startHeight;
    }

    public void selectNode(int i){
        nodeSelected = i;
        repaint();
    }

    public void deselectNode() {
        nodeSelected = -1;
        repaint();
    }

}
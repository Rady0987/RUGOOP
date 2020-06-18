package nl.rug.oop.grapheditor.controller;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.view.DrawPanel;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * Implements the ability to select nodes
 */
public class SelectionController extends MouseInputAdapter {

    private GraphModel graph;
    private DrawPanel panel;

    /**
     * Create a new selection controller that receives mouse events from the DrawPanel
     * supplied to this constructor
     *
     * @param graph The actual grapheditor
     * @param panel    DrawPanel needed to receive mouse events from
     */
    public SelectionController(GraphModel graph, DrawPanel panel) {
        this.graph = graph;
        this.panel = panel;
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
    }

    /**
     * If the mouse button is clicked in the area where a node is located,
     * the node gets selected
     *
     * @param event The MouseEvent needed to locate the position of the cursor
     */
    @Override
    public void mouseClicked(MouseEvent event) {
        int sizeOfNodes = graph.getNodeListSize();
        boolean nodeSelected = false;
        int i=0;
        while(i < sizeOfNodes && !nodeSelected){ 
            double xVal = graph.getNode(i).x * panel.getRatioX();
            double yVal = graph.getNode(i).y * panel.getRatioY();
            double widthVal = graph.getNode(i).width * panel.getRatioX();
            double heightVal = graph.getNode(i).height * panel.getRatioY();
            if (event.getX() >= xVal && event.getX() <= (xVal + widthVal) &&
                event.getY() >= yVal && event.getY() <= (yVal + heightVal)
            ){
                nodeSelected = true;
                panel.selectNode(i);
            }
            i++;
        }
    }

}

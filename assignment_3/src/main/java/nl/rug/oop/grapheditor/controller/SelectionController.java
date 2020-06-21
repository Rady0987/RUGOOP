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
    private static int selectedNode;
    boolean nodeSelected = false;
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
        int i=0;
        while(i < sizeOfNodes && !nodeSelected){
            double xVal = graph.getNode(i).getX() * panel.getRatioX();
            double yVal = graph.getNode(i).getY() * panel.getRatioY();
            double widthVal = graph.getNode(i).getWidth() * panel.getRatioX();
            double heightVal = graph.getNode(i).getHeight() * panel.getRatioY();
            if (event.getX() >= xVal && event.getX() <= (xVal + widthVal) &&
                event.getY() >= yVal && event.getY() <= (yVal + heightVal)){
                nodeSelected = true;
                panel.selectNode(i);
                selectedNode = i;
            }
            i++;
        }
    }
    /**
     *
     *
     * @param event The MouseEvent needed to locate the position of the cursor
     */
    @Override
    public void mouseReleased(MouseEvent event) {
        nodeSelected = false;
        panel.deselectNode();

    }

    /**
     * If a card is selected it is moved relative to the positions the mouse
     * was first pressed.
     *
     * @param event The MouseEvent needed to locate the position of the cursor
     */
    @Override
    public void mouseDragged(MouseEvent event) {
        super.mouseDragged(event);
        if (nodeSelected) {
            double halfWidth = graph.getNode(selectedNode).getWidth() * panel.getRatioX() / 2;
            double halfHeight = graph.getNode(selectedNode).getHeight() * panel.getRatioY() / 2;
            graph.move(selectedNode, (int)(event.getX() - halfWidth), (int)(event.getY() - halfHeight));
        }
    }

    public static int getSelectedNode() {
        return selectedNode;
    }
}

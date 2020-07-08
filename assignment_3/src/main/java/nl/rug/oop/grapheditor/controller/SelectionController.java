package nl.rug.oop.grapheditor.controller;

import nl.rug.oop.grapheditor.controller.actions.MoveNodeAction;
import nl.rug.oop.grapheditor.controller.actions.NewEdgeAction;
import nl.rug.oop.grapheditor.model.Edge;
import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.Node;
import nl.rug.oop.grapheditor.view.DrawPanel;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * This class creates a new selection controller of the graph editor.
 */
public class SelectionController extends MouseInputAdapter {

    private static GraphModel graph;
    private static Edge addedEdge;
    private final DrawPanel panel;
    private static Node selectedNode;
    private static boolean newEdge = false;
    private boolean isMousePressed = false;
    private Point oldCoordinates;
    private Point cursorOffset;
    private boolean mouseDragged = false;

    /**
     * Constructor.
     *
     * @param graph The GraphModel.
     * @param panel The JPanel, needed to receive mouse events from.
     */
    public SelectionController(GraphModel graph, DrawPanel panel) {
        this.graph = graph;
        this.panel = panel;
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
    }

    /**
     * This method selects or deselects a node when the user clicks on it.
     *
     * @param event The MouseEvent that locates the position of the cursor.
     */
    @Override
    public void mouseClicked(MouseEvent event) {
        selectedNode = checkForNode(event.getPoint());
        if (selectedNode != null) {
            if(selectedNode.isSelected()) {
                graph.setNodeUnselected(selectedNode);
            } else {
                graph.setNodeSelected(selectedNode);
            }
            /* If the newEdge button is clicked, this boolean becomes true and the new edge is added */
            if(newEdge) {
                addedEdge = new Edge(checkForNode(event.getPoint()), graph.getSelectedNodes().get(0));
                NewEdgeAction action = new NewEdgeAction(graph);
                action.createEdit(addedEdge);
                graph.setSelectedNodeNull();
                newEdge = false;
            }
        } else {
            /* When user clicks away from any nodes, the nodes selection is reset */
            graph.setSelectedNodeNull();
        }
    }

    /**
     * This method saves the coordinates of a node when the user presses on one.
     *
     * @param event The MouseEvent that locates the position of the cursor.
     */
    @Override
    public void mousePressed(MouseEvent event) {
        selectedNode = checkForNode(event.getPoint());
        /* When user clicks on a specific node, its coordinates before it is moved are saved for the undo action*/
        if(selectedNode != null){
            cursorOffset = event.getPoint();
            cursorOffset.x -= selectedNode.x;
            cursorOffset.y -= selectedNode.y;
            oldCoordinates = (Point) selectedNode.getCoordinates().clone();
            isMousePressed = true;
        }
    }

    /**
     * This method creates a new undoable edit after a node is moved and sets the triggers off where the mouse is released.
     *
     * @param event The MouseEvent that locates the position of the cursor.
     */
    @Override
    public void mouseReleased(MouseEvent event) {
        /* If user dragged a node and then released the mouse, a new move edit is created */
        if (mouseDragged) {
            MoveNodeAction action = new MoveNodeAction(graph, selectedNode, oldCoordinates);
            action.actionPerformed();
        }
        mouseDragged = false;
        selectedNode = null;
        isMousePressed = false;
    }

    /**
     * This method changes the position of a node according to the point where the mouse is released.
     *
     * @param event The MouseEvent that locates the position of the cursor.
     */
    @Override
    public void mouseDragged(MouseEvent event) {
        super.mouseDragged(event);
        if (isMousePressed) {
            selectedNode.setX((event.getX() - cursorOffset.x));
            selectedNode.setY((event.getY() - cursorOffset.y));
            mouseDragged = true;
        }
        graph.update();
    }

    /**
     * This method checks if the cursor is in the area of a node.
     *
     * @param point The position of the cursor.
     * @return null if there is no node or the node that is located at that point.
     */
    private static Node checkForNode(Point point) {
        for (Node node : graph.getNodeList()) {
            if (node.getNodeArea().contains(point)) {
                return node;
            }
        }
        return null;
    }

    /**
     * This method sets the cursor coordinates when the mouse is moved.
     *
     * @param event The MouseEvent that locates the position of the cursor.
     */
    @Override
    public void mouseMoved(MouseEvent event){
        super.mouseMoved(event);
        if (newEdge){
            panel.setMousePosition(event.getPoint());
            graph.update();
        }
    }

    /**
     * This method sets the value of the newEdge boolean, whether the button is pressed or not.
     *
     * @param pressed The truth value.
     */
    public static void setNewEdge(boolean pressed) {
        newEdge = pressed;
    }

    /**
     * This method gets the value of the newEdge boolean, whether the button is pressed or not.
     *
     * @return  newEdge The truth value.
     */
    public static boolean isNewEdgePressed() {
        return newEdge;
    }

}

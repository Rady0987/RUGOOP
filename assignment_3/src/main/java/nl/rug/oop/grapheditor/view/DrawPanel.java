package nl.rug.oop.grapheditor.view;
import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observer;
import java.util.Observable;

/**
 * DrawPanel class.
 */
public class DrawPanel extends JPanel implements Observer {

    private int startWidth = 1300;
    private int startHeight = 900;
    private GraphModel graph;

    /**
     * Constructor
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
     * Method that paints the nodes
     *
     * @param g Graphics component
     */
    private void paintNodes(Graphics g) {
        int sizeOfNodes = graph.getNodeListSize();
        for(int i = 0; i < sizeOfNodes; i++){  
            g.setColor(Color.lightGray);
            if(graph.getSelectedNode() == i){
                g.setColor(Color.RED);
            }
            int xVal = (int) (graph.getNode(i).getX() * getRatioX());
            int yVal = (int) (graph.getNode(i).getY() * getRatioY());
            int widthVal = (int) (graph.getNode(i).getWidth() * getRatioX());
            int heightVal = (int)(graph.getNode(i).getHeight() * getRatioY());

            g.fillRect(xVal, yVal, widthVal, heightVal);
            g.setColor(Color.black);
            g.drawRect(xVal, yVal, widthVal, heightVal);
            int sizeText = 150;
            g.setFont (new Font ("Courier", Font.BOLD, sizeText));
            int width = g.getFontMetrics().stringWidth(graph.getNode(i).name);
            int height = g.getFontMetrics().getHeight();

            while(width > ((3 * widthVal)/4)){
                sizeText--;
                g.setFont(new Font ("Courier", Font.BOLD, sizeText));
                width = g.getFontMetrics().stringWidth(graph.getNode(i).name);  
            }
            g.drawString(graph.getNode(i).name, xVal + widthVal/8, yVal + height/3);
        }
    }

    /**
     * Method that paints the edges
     *
     * @param g Graphics component
     */
    private void paintEdges(Graphics g) {
        g.setColor(Color.lightGray);
        for(int i = 0; i < graph.getEdgeListSize(); i++){
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
     * Method that paints a new created edge
     *
     * @param g Graphics component
     */
    public void paintAddingEdge(Graphics g) {
        if (graph.getSelectedNode() == -1 && graph.getaddEdgeButton()) {
            g.setColor(new Color(135, 20, 100));
            int node = graph.getFirstSelectedNode();
            int x = graph.getNode(node).getX() * getWidth()/startWidth;
            x += (graph.getNode(node).getWidth() * getWidth()/startWidth)/2;
            int y = graph.getNode(node).getY() * getHeight()/startHeight;
            y += (graph.getNode(node).getHeight() * getHeight()/startHeight)/2;

            Graphics2D g2D = (Graphics2D)g;
            g2D.setStroke(new BasicStroke(5.0F));
            g.drawLine(x, y, graph.getMouseX(), graph.getMouseY());
        }
    }

    /**
     * Method that paints a new text box
     *
     * @param g Graphics component
     */
    public void paintTextBox(Graphics g) {
        if (graph.isRenameButton() && graph.getSelectedNode() != -1) {
            int x = (getWidth() - 300);
            textField textField = new textField(x, 0, graph);
            textField.setBounds(x, 0, 280, 50);
            textField.setToolTipText("Rename the selected node.");
            add(textField);
            textField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    super.keyPressed(e);
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        graph.renameSelectedNode(textField.getText());
                        textField.setVisible(true);
                    }
                }
            });
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
        paintTextBox(g);
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

}
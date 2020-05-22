package cardgame.controller;

import cardgame.model.DrawGame;
import cardgame.view.DrawPanel;

import javax.swing.event.MouseInputAdapter;

import java.awt.event.MouseEvent;

/**
 * Implements the ability to drag the top card of the deck to the discard
 * area of a drawpanel
 */
public class CardDragger extends MouseInputAdapter {

    private DrawGame drawGame;
    private DrawPanel panel;

    /**
     * Boolean denoting whether a card is selected.
     */
    private boolean selected;

    /**
     * Starting x position of a mousePressed. Used for dragging.
     */
    private int startX;

    /**
     * Starting y position of a mousePressed. Used for dragging.
     */
    private int startY;

    /**
     * Create a new card dragger that receives mouse events from the DrawPanel
     * supplied to this constructor
     *
     * @param drawGame The actual DrawGame
     * @param panel    DrawPanel needed to receive mouse events from
     */
    public CardDragger(DrawGame drawGame, DrawPanel panel) {
        this.drawGame = drawGame;
        this.panel = panel;
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
        selected = false;
    }

    /**
     * If the mouse button is pressed in the area where the top card is
     * drawn (obviously a lack of drawable cards makes this impossible)
     * that card is 'selected' so it can be dragged.
     *
     * @param event The MouseEvent needed to locate the position of the cursor
     */
    @Override
    public void mousePressed(MouseEvent event) {
        if (drawGame.getMovableCard() != null) {
            if (event.getX() > panel.getMovableX() &&
                    event.getX() < panel.getMovableX() + panel.cardWidth() &&
                    event.getY() > panel.getMovableY() &&
                    event.getY() < panel.getMovableY() + panel.cardHeight()
            ) {
                selected = true;
                startX = event.getX();
                startY = event.getY();
            }
        }
    }

    /**
     * When the top card is released with the mouse in the discard square,
     * the card is moved.
     *
     * @param event The MouseEvent needed to locate the position of the cursor
     */
    @Override
    public void mouseReleased(MouseEvent event) {
        if (selected) {
            if (panel.inPlayerArea(event.getPoint()))
                drawGame.move();
            else {
                drawGame.getMovableCard().setRelativeX(0);
                drawGame.getMovableCard().setRelativeY(0);
            }
        }
        selected = false;
    }

    /**
     * If a card is selected it is moved relative to the positions the mouse
     * was first pressed.
     *
     * @param event The MouseEvent needed to locate the position of the cursor
     */
    @Override
    public void mouseDragged(MouseEvent event) {
        if (selected) {
            drawGame.getMovableCard().setRelativeX(event.getX() - startX);
            drawGame.getMovableCard().setRelativeY(event.getY() - startY);
        }
    }

}

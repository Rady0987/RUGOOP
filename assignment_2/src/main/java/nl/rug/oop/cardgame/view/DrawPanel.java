package cardgame.view;

import cardgame.model.card.Card;

import cardgame.model.DrawGame;
import cardgame.model.card.MovableCard;
import cardgame.view.textures.CardBack;
import cardgame.view.textures.CardBackTextures;
import cardgame.view.textures.CardTextures;

import javax.swing.JPanel;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.util.Observer;
import java.util.Observable;

/**
 * View of Draw
 */
public class DrawPanel extends JPanel implements Observer {

    /**
     * Card spacing defined in amount of pixels
     */
    private static final int CARD_SPACING = 2;
    private static final int Y_OFFSET = Card.values().length * CARD_SPACING;

    /**
     * Use double to prevent mistakes with integer division
     * Should match the texture dimensions for best results
     */
    private static final double CARD_WIDTH = 436.0;
    private static final double CARD_HEIGHT = 600.0;

    /**
     * Background color
     */
    private static final Color BACKGROUND_COLOR = new Color(0x7E, 0x35, 0x4D);

    private DrawGame drawGame;

    private int movableX;
    private int movableY;
    private int partGame;

    /**
     * Get the number of pixels in X this card has been moved
     */
    public int getMovableX() {
        return movableX;
    }

    /**
     * Get the number of pixels in Y this card has been moved
     */
    public int getMovableY() {
        return movableY;
    }

    /**
     * Create a new DrawPanel
     */
    public DrawPanel(DrawGame drawGame, int partGame) {
        this.partGame = partGame;
        this.drawGame = drawGame;
        drawGame.addObserver(this);
        setBackground(BACKGROUND_COLOR);
        setVisible(true);
        setOpaque(true);
    }

    /**
     * Calculates discard area
     *
     * @param point The point where the mouse clicked
     * @return Whether the current point is in the discard area.
     */
    public boolean inPlayerArea(Point point) {
        int turn = drawGame.getTurn();
        double posX = point.getX();
        double posY = point.getY();
        if(turn == 0){
           return (posX > getWidth()/4 && posX < 3 *(getWidth()/4) && posY < getHeight()/4); 
        }
        if(turn == 1){
            return(posY > getHeight()/4 && posY < 3 * (getHeight()/4) && posX > 3 * (getWidth()/4)); 
        }
        if(turn == 2){
            return(posX > getWidth()/4 && posX< 3 * (getWidth()/4) && posY> 3 * (getHeight()/4));
        }
        return (posY > getHeight()/4 && posY < 3 *(getHeight()/4) && posX < getWidth()/4);
    }

    /**
     * Paint the areas in which deck and discard pile can be found
     */
    private void paintAreas(Graphics g) {
        g.setColor(Color.YELLOW);
        g.drawString("Player 4", 10, getHeight()/4);
        g.drawRect(0, getHeight()/4, getWidth() / 4, getHeight()/2);
        g.drawString("Player 2", 3 *(getWidth()/4) + 10, getHeight()/4);
        g.drawRect(3 * (getWidth()/4), getHeight()/4, getWidth()/4, getHeight() /2);
        g.drawString("Player 1", getWidth()/4 + 10, getHeight()/4+ 10);
        g.drawRect(getWidth()/4, 0, getWidth() / 2, getHeight()/4);
        g.drawString("Player 3", getWidth()/4 + 10, 3 * (getHeight()/4) - 10);
        g.drawRect(getWidth()/4, 3 *(getHeight()/4), getWidth()/2, getHeight()/4);
        g.drawString("Deck Area", 0, 10);
        g.setColor(Color.BLACK);
    }

    private void printInformation(Graphics g){
        g.setColor(Color.YELLOW);
        int turn = drawGame.getTurn()+ 1; 
        g.drawString("It's the turn of Player:" + turn , getWidth()/4 +10, getHeight()/2 - 10);
        int round = drawGame.getRound();
        if(round ==1){ 
            g.drawString("Which card do you think it's gonna be?" , getWidth()/4+10, getHeight()/2);
            g.drawRect(getWidth()/4, getHeight()/2+ 10, getWidth() / 2, 3 * (getHeight()/4));
            g.drawString("RED", getWidth()/4, 5 * getHeight()/8);
            g.drawRect(getWidth()/2, getHeight()/2+ 10, 3 * (getWidth() / 4), 3 * (getHeight()/4));
            g.drawString("BLACK", getWidth()/2, 5 * getHeight()/8);
        }
        if(round ==2){
            g.drawString("Is the upcoming card higher or lower than the card you already have?" , getWidth()/4 +10, getHeight()/2);
        }
        if(round ==3){
            g.drawString("Is the upcoming card between or outside of the cards you already have?" , getWidth()/4 +10, getHeight()/2);
        }
        if(round ==4){
            g.drawString("Do you already have the card or not?" , getWidth()/4 + 10, getHeight()/2);
        }
        g.setColor(Color.BLACK);

    }

    /**
     * Get the scaled spacing between edges and cards
     */
    private int getSpacing() {
        return (int) (((getHeight() * 20) / CARD_HEIGHT)/4);
    }

    /**
     * Get the scaled width of cards. Default height is 600, default
     * width is 436, and cards are scaled depending on which dimension limits
     * their relative dimensions
     */
    public int cardWidth() {
        if ((getHeight() * CARD_HEIGHT) / (getWidth() * CARD_WIDTH) <= 1.0)
            return (int) ((cardHeight() * CARD_WIDTH) / CARD_HEIGHT);
        return (getWidth()/4 - getSpacing() * 3 - Card.values().length) / 4;
    }

    /**
     * Get the scaled height of cards. Default height is 600, default
     * width is 436, and cards are scaled depending on which dimension limits
     * their relative dimensions
     */
    public int cardHeight() {
        if ((getHeight() * CARD_HEIGHT) / (getWidth() * CARD_WIDTH) > 1.0)
            return (int) ((cardWidth() * CARD_HEIGHT) / CARD_WIDTH);
        return (getHeight()/4 - getSpacing() * 2 - Card.values().length);
    }

    /**
     * Draw the deck
     *
     * @param g Graphics object needed for drawing
     */
    private void paintDeck(Graphics g) {
        int depth;
        BufferedImage cardBackTexture = CardBackTextures.getTexture(CardBack.CARD_BACK_BLUE);

        for (depth = 0; depth < drawGame.getDeck().size(); depth++) {
            int posX = getSpacing() + depth/2;
            int posY = getSpacing() + Y_OFFSET/4 - CARD_SPACING * depth/4;
            g.drawImage(cardBackTexture, posX, posY, cardWidth(), cardHeight(), this);
            g.drawRect(posX, posY, cardWidth(), cardHeight());
        }

        MovableCard dependency = drawGame.getMovableCard();
        if (dependency == null) {
            return;
        }

        movableX = getSpacing() + depth/2 + dependency.getRelativeX();
        movableY = getSpacing() + Y_OFFSET/4 - CARD_SPACING * depth/4 + dependency.getRelativeY();
        g.drawImage(cardBackTexture, movableX, movableY, cardWidth(), cardHeight(), this);
        g.drawRect(movableX, movableY, cardWidth(), cardHeight());
    }

    /**
     * Draw the discard pile
     *
     * @param g Graphics object needed for drawing
     */
    private void paintHand(Graphics g, int player) {
        int depth = 0;
        for (Card card : drawGame.getHand(player)) {
            int posX = 0;
            int posY = 0;
            if(player%2 == 0){
                posX += getWidth()/4 + (cardWidth()+ CARD_SPACING/4) * depth;
            }else{
                posY += getHeight()/4 +(cardHeight() + CARD_SPACING/4) * depth;
            }
            if(player == 1){
                posX += 3 * (getWidth()/4);
            }
            if(player == 2){
                posY += 3 * (getHeight()/4);
            }
            g.drawImage(CardTextures.getTexture(card)
                    , posX, posY, cardWidth(), cardHeight(), this);
            g.drawRect(posX, posY, cardWidth(), cardHeight());
            ++depth;
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
        paintAreas(g);
        if(partGame == 1){
            for(int i =0; i < 4; i++){
                paintHand(g,i);
            }
            paintDeck(g);
            printInformation(g);
        }
        else{

        }
    }

    /**
     * Tell this DrawPanel that the object it displays has changed
     */
    @Override
    public void update(Observable observed, Object message) {
        repaint();
    }

}

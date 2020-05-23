package nl.rug.oop.cardgame.view;

import nl.rug.oop.cardgame.model.card.Card;
import nl.rug.oop.cardgame.model.Game;
import nl.rug.oop.cardgame.model.card.MovableCard;
import nl.rug.oop.cardgame.view.textures.*;
import javax.swing.JPanel;
import java.awt.*;
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

    private Game game;

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
    public DrawPanel(Game game) {
        this.game = game;
        partGame = 1;
        game.addObserver(this);
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
        int turn = game.getTurn();
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
        g.setFont(new Font("Calibre", Font.PLAIN, 20));
        g.setColor(Color.YELLOW);
        g.drawString("Player 4",getWidth()/5 - 25, getHeight()/4 + 25);
        g.drawRect(0, getHeight()/4, getWidth() / 4, getHeight()/2);
        g.drawString("Player 2", (getWidth()/4)*3 + 10, getHeight()/4 + 25);
        g.drawRect(3 * (getWidth()/4), getHeight()/4, getWidth()/4, getHeight() /2);
        g.drawString("Player 1", getWidth()/4 + 10, getHeight()/4 - 6);
        g.drawRect(getWidth()/4, 0, getWidth() / 2, getHeight()/4);
        g.drawString("Player 3", getWidth()/4 + 10, 3 * (getHeight()/4) + 20);
        g.drawRect(getWidth()/4, 3 *(getHeight()/4), getWidth()/2, getHeight()/4);
        g.drawString("Deck Area", getWidth()/6 - 70 , 20);
        g.setColor(Color.BLACK);
    }

    /**
     * Print the answer variants for every state.
     *
     * @param g Graphics object needed for drawing
     */
    private void printInformation(Graphics g){
        g.setFont(new Font("Calibre", Font.PLAIN, 20));
        g.setColor(Color.YELLOW);
        int turn = game.getTurn()+ 1;
        g.drawString("It's the turn of Player:" + turn , getWidth()/4 +10, getHeight()/2 - 20);
        int round = game.getRound();
        if(round ==1){ 
            g.drawString("Which card do you think it's gonna be?" , getWidth()/4+10, getHeight()/2 );
            g.drawString("Press option one for: RED", getWidth()/4+ 10, getHeight()/2 + 20);
            g.drawString("Press option two for: BLACK", getWidth()/4+ 10, getHeight()/2 + 40);
        }
        if(round ==2){
            g.drawString("Is the upcoming card higher or lower than the card you" , getWidth()/4 +10, getHeight()/2);
            g.drawString("already have?", getWidth()/4 +30, getHeight()/2 + 20);
            g.drawString("Press option one for: LOWER", getWidth()/4+ 10, getHeight()/2 + 40);
            g.drawString("Press option two for: HIGHER", getWidth()/4+ 10, getHeight()/2 + 60);
            g.drawString("Press option three for: THE SAME", getWidth()/4+ 10, getHeight()/2 + 80);
        }
        if(round ==3){
            g.drawString("Is the upcoming card between or outside of the cards you" , getWidth()/4 +10, getHeight()/2);
            g.drawString("already have?", getWidth()/4 +30, getHeight()/2 + 20);
            g.drawString("Press option one for: BETWEEN", getWidth()/4+ 10, getHeight()/2 + 40);
            g.drawString("Press option two for: OUTSIDE", getWidth()/4+ 10, getHeight()/2 + 60);
            g.drawString("Press option three for: THE SAME", getWidth()/4+ 10, getHeight()/2 + 80);
        }
        if(round ==4){
            g.drawString("Do you already have a card of the same suit or not?" , getWidth()/4 + 10, getHeight()/2);
            g.drawString("Press option one for: ALREADY HAVE IT", getWidth()/4+ 10, getHeight()/2 + 20);
            g.drawString("Press option two for: I DO NOT HAVE IT", getWidth()/4+ 10, getHeight()/2 + 40);
            g.drawString("Press option three for: I DO NOT HAVE IT, AND IT IS THE LAST", getWidth()/4+ 10, getHeight()/2 + 60);
            g.drawString("KIND I NEED TO HAVE FOUR DIFFERENT KIND OF CARDS (ALLIN)",getWidth()/4 + 30, getHeight()/2 + 80);
        }
        g.setColor(Color.BLACK);
    }

    /**
     * Print the feedback after a player makes a choise.
     * @param g Graphics object needed for drawing
     */
    private void printAnswers(Graphics g){
        if(game.getCardChosen() == false){
            g.drawString("CHOOSE AN OPTION FIRST!!!", getWidth()/4+ 10, getHeight()/2 + 130);
        }
        if(game.isStarted() == true){
            if(game.didHeGuessRight() == true){
                g.drawString("This was right!", getWidth()/4+ 10, getHeight()/2 + 110);
            } else{
                g.drawString("Unfortunately, you were wrong!", getWidth()/4+ 10, getHeight()/2 + 110);
            }
        }
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

        for (depth = 0; depth < game.getDeck().size(); depth++) {
            int posX = getSpacing() + depth/2;
            int posY = getSpacing() + Y_OFFSET/4 - CARD_SPACING * depth/4;
            g.drawImage(cardBackTexture, posX, posY, cardWidth(), cardHeight(), this);
            g.drawRect(posX, posY, cardWidth(), cardHeight());
        }

        MovableCard dependency = game.getMovableCard();
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
        g.setColor(Color.BLACK);
        int depth = 0;
        for (Card card : game.getHand(player)) {
            int posX = 0;
            int posY = 0;
            if(player == 0){ //Player 2
                posX += getWidth()/4 + (cardWidth()+ CARD_SPACING/4) * depth + 3;
                posY += 3;
            }
            if(player == 1){ //Player 2
                posX += 9 * (getWidth()/10) + 19;
                posY += getHeight()/4 +(cardHeight() + CARD_SPACING/4) * depth + 3;
            }
            if(player == 2){ //Player 3
                posY += 3 * (getHeight()/4) + 62;
                posX += getWidth()/4 + (cardWidth()+ CARD_SPACING/4) * depth +3;
            }
            if(player == 3){ //Player 4
                posY += ((getHeight()/4) + 3) + (cardHeight() + CARD_SPACING/4) * depth;
                posX = 3;
            }
            g.drawImage(CardTextures.getTexture(card), posX, posY, cardWidth(), cardHeight(), this);
            g.drawRect(posX, posY, cardWidth(), cardHeight());
            ++depth;
        }
    }

    /**
     * Prints the scoreboard
     *
     * @param g Graphics object needed for drawing
     */
    public void printScoreboard(Graphics g) {
        g.setFont(new Font("Calibre", Font.PLAIN, 20));
        g.setColor(Color.YELLOW);
        g.drawString("Scoreboard", getWidth()/8 , 80);
        g.drawString("Player 1: " + Game.getPlayer(0).getPointsString(), getWidth()/7, 100);
        g.drawString("Player 2: " + Game.getPlayer(1).getPointsString(), getWidth()/7, 120);
        g.drawString("Player 3: " + Game.getPlayer(2).getPointsString(), getWidth()/7, 140);
        g.drawString("Player 4: " + Game.getPlayer(3).getPointsString(), getWidth()/7, 160);
    }

    /**
     * Prints the winner
     *
     * @param g Graphics object needed for drawing
     */
    public void printWinner(Graphics g) {
        if(Game.getWinner() == -1) {
            g.drawString("DRAW!", getWidth()/2 - 220, getHeight()/2 - 40);
        } else {
            int winner = Game.getWinner() + 1;
            g.drawString("Player " + winner + " is the winner!!!", getWidth()/2 - 220, getHeight()/2 - 40);
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
        partGame = game.getPartGame();
        paintAreas(g);
        printScoreboard(g);
        if(partGame == 1){
            for(int i =0; i < 4; i++){
                paintHand(g,i);
            }
            paintDeck(g);
            printInformation(g);
            printAnswers(g);
        }
        else{
            for(int i =0; i < 4; i++){
                paintHand(g,i);
            }
            g.setFont(new Font("Calibre", Font.PLAIN, 40));
            g.setColor(Color.YELLOW);
            printWinner(g);
            g.drawString("Shuffle the deck to", getWidth()/2 - 200, getHeight()/2 + 40);
            g.drawString("start a new game!", getWidth()/2 - 190, getHeight()/2 + 80);
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

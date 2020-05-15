package nl.rug.oop.cardgame.view;
import nl.rug.oop.cardgame.model.Deck;
import nl.rug.oop.cardgame.model.Game;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class gamePanel extends JPanel implements Observer{
    private Game game;
    private Deck deck;

    /**
     * Initialises this drawpanel with a gray background
     *
     * @param deck
     * @param game
     */

    public gamePanel(Game game, Deck deck) {
        setBackground(Color.gray);
        this.deck = deck;
        this.game = game;
        game.addObserver(this);
        deck.addObserver(this);
    }

    /**
     * Draws the number of cards in the deck
     *
     * @param g Graphics component used for drawing
     */

    private void drawDeck(Graphics g) {
        Dimension dimension = getSize();
        g.setFont(new Font("ComicSans", Font.BOLD, 36));
        g.drawString(String.valueOf(deck.getCardsNr()), dimension.width / 2, dimension.height / 2);
    }

    /**
     * Custom implementation of the paintComponent function that draws the number of cards
     *
     * @param g Graphics component used for drawing
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawDeck(g);
    }

    /**
     * Method that is called when the model updates
     *
     * @param observable Observable object (not really used, you can ignore these)
     * @param o          Object (not really used, you can ignore these)
     */
    @Override
    public void update(Observable observable, Object o) {
        repaint();
    }
}






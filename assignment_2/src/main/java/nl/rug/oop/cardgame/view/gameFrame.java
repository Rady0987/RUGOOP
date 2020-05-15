package nl.rug.oop.cardgame.view;
import nl.rug.oop.cardgame.model.Deck;
import nl.rug.oop.cardgame.model.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Frame class that displays the basic window
 */

public class gameFrame extends JFrame {
    /**
     * Creates a simple JFrame
     */
    public gameFrame() {
        super("Ride the Bus");

        /* Create new counter */
        Game game = new Game();
        Deck deck = new Deck();

        /* Makes the program exit when we close the JFrame */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Do not allow the frame to be resized */
        setResizable(false);
        /* Set the size of the JFrame */
        setPreferredSize(new Dimension(1200, 800));
        /* Try to make all the components at or above their preferred size */
        pack();
        /* set the JMenuBar */
        //setJMenuBar(new ButtonMenu());

        /* panel for the frame */
        gamePanel gamePanel = new gamePanel(game, deck);
        /* Add panel to the frame */
        add(gamePanel);
        /* Create the frame in the middle of the screen */
        setLocationRelativeTo(null);
        /* Make the frame visible */
        setVisible(true);
    }
}
package nl.rug.oop.cardgame.view;

import nl.rug.oop.cardgame.controller.*;
import nl.rug.oop.cardgame.model.Game;

import javax.swing.*;
import java.awt.*;

public class DrawFrame extends JFrame {

    public DrawFrame(Game game) {
        /* Create a frame for the GUI */
        super("Card Game");
        /* Make sure our program exits when we close the frame */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Add a menu to the frame */
        setJMenuBar(new ButtonBar(game));
        /* Create a view for the game */
        DrawPanel panel = new DrawPanel(game);

        /* Create a controller for the mouse input */
        new CardDragger(game, panel);
        /* Add the view to the frame */
        add(panel);
        /* Set the size of the frame */
        setPreferredSize(new Dimension(1300, 900));
        /* Try to make all the components at or above their preferred size */
        pack();
        /* Center the frame on the screen */
        setLocationRelativeTo(null);
        /* Make sure we can actually see the frame */
        setVisible(true);
    }
}

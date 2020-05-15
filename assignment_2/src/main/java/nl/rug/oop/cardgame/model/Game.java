package nl.rug.oop.cardgame.model;


import java.util.ArrayList;
import java.util.Observable;

public class Game extends Observable {
    private ArrayList<Player> Players;
    private ArrayList<Round> Rounds;

    public void startGame () {
        Deck deck = new Deck();
        deck.newDeck();
        deck.shuffleDeck();
        deck.printDeck();
    }
}

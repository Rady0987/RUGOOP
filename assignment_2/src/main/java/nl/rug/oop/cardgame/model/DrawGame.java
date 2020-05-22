package cardgame.model;

import cardgame.model.card.MovableCard;
import cardgame.model.deck.AbstractDeck;
import cardgame.model.deck.CompleteDeck;
import cardgame.model.Player;

import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;

/**
 * Represents the game
 */
public class DrawGame extends Observable implements Observer {

    private AbstractDeck deck;
    private MovableCard movable;
    private ArrayList<Player> players;
    private int turn;
    private int round;

    /**
     * Create a deck with all cards in Card
     */
    private static AbstractDeck makeDeck() {
        AbstractDeck deck = new CompleteDeck();
        deck.shuffle();
        return deck;
    }

    /**
     * Creates a movable card and adds an Observer to it
     */
    private void createMovableCard() {
        if (movable != null) {
            movable.deleteObserver(this);
            movable = null;
        }
        if (!deck.isEmpty()) {
            movable = new MovableCard(deck.draw());
            movable.addObserver(this);
        }
    }



    /**
     * Create a new Draw with all 54 different cards in the deck once
     */
    public DrawGame() {
        deck = makeDeck();
        createMovableCard();
        players = new ArrayList<Player>();
        for(int i =0; i<4; i++){
            Player player = new Player(i);
            players.add(player);
        }
        turn = 0;
        round = 1;
    }

    /**
     * Getter for deck so it may be looked at without being changed
     */
    public AbstractDeck getDeck() {
        return deck;
    }

    /**
     * Observe the state of the discard pile without allowing other classes
     * access
     */
    public Hand getHand(int i) {
        return players.get(i).getHand();
    }

    /**
     * Look at which card is movable
     */
    public MovableCard getMovableCard() {
        return movable;
    }


    public void round1(){
        for(int i = 0; i<4;i++){
            
        }
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }

    /**
     * Draw a card and put it on the discard pile
     */
    public void move() {
        if (movable != null) {
            players.get(turn).getHand().put(movable.getCard());
        }
        createMovableCard();
        setChanged();
        notifyObservers();
        if( turn == 3){
            ++round;
        }
        turn = (turn +1)%4;
    }

    /**
     * Put all cards back into the deck and shuffle it
     */
    public void reset() {
        deck = makeDeck();
        createMovableCard();
        players = new ArrayList<Player>();
        for(int i =0; i<4; i++){
            Player player = new Player(i);
            players.add(player);
        }
        setChanged();
        notifyObservers();
    }

    /**
     * If the movable card updates this updates too
     */
    @Override
    public void update(Observable observable, Object message) {
        setChanged();
        notifyObservers();
    }

    public int getTurn(){
        return turn;
    }

    public int getRound(){
        return round;
    }

}

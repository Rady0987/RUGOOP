package nl.rug.oop.cardgame.model;

import nl.rug.oop.cardgame.model.card.*;
import nl.rug.oop.cardgame.model.deck.*;
import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;

/**
 * Represents the game
 */
public class Game extends Observable implements Observer {

    private AbstractDeck deck;
    private MovableCard movable;
    private static ArrayList<Player> players;
    private int turn;
    private int round;
    private int option;
    private int partGame;
    private boolean cardChosen;
    private boolean goodGuess;
    private boolean start;

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
     * Create a new Draw with all 52 different cards in the deck once
     */
    public Game() {
        deck = makeDeck();
        createMovableCard();
        players = new ArrayList<Player>();
        for(int i =0; i<4; i++){
            Player player = new Player(i);
            players.add(player);
        }
        turn = 0;
        round = 1;
        option =0;
        partGame = 1;
        cardChosen = true;
        goodGuess = false;
        start = false;
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

    /**
     * Get player with a specific index.
     *
     * @param i the index
     */
    public static Player getPlayer(int i) {
        return players.get(i);
    }

    /**
     * Draw a card and put it on the hand
     */
    public void move() {
        if(option == 0){
            cardChosen = false;
        }
        if (partGame == 1 && option != 0 && movable != null) {
            start = true;
            Card card = movable.getCard();
            checkIfRight(card);
            players.get(turn).getHand().put(card);
            if( turn == 3){
                ++round;
            }
            turn = (turn +1)%4;
            cardChosen = true;
            if(round == 5){
                partGame = 2;
            }
        }
        createMovableCard();
        setChanged();
        notifyObservers();
    }

    /**
     * Method that checks players' answers for the 2nd round.
     * @param newCard a card that is drawn from the deck
     */
    public void checkRound2(Card newCard) {
        if(option == 1){
            if(newCard.getHeight() < players.get(turn).getHand().top().getHeight()){
                goodGuess = true;
                players.get(turn).addPoint();
            }else{
                goodGuess = false;
            }
        }
        if(option == 2){
            if(newCard.getHeight() > players.get(turn).getHand().top().getHeight()){
                goodGuess = true;
                players.get(turn).addPoint();
            }else{
                goodGuess = false;
            }
        }
        if(option == 3){
            if(newCard.getHeight() == players.get(turn).getHand().top().getHeight()){
                goodGuess = true;
                players.get(turn).addPoint();
            }else{
                goodGuess = false;
            }
        }
    }

    /**
     * Method that checks players' answers for the 3rd round.
     * @param newCard a card that is drawn from the deck
     */
    public void checkRound3(Card newCard) {
        if(option == 1){
            if((newCard.getHeight() < players.get(turn).getHand().top().getHeight() &&
                    newCard.getHeight() > players.get(turn).getHand().iterator().next().getHeight()) ||
                    (newCard.getHeight() > players.get(turn).getHand().top().getHeight() &&
                            newCard.getHeight() < players.get(turn).getHand().iterator().next().getHeight())){
                goodGuess = true;
                players.get(turn).addPoint();
            }else{
                goodGuess = false;
            }
        }
        if(option == 2){
            if((newCard.getHeight() < players.get(turn).getHand().top().getHeight() &&
                    newCard.getHeight() > players.get(turn).getHand().iterator().next().getHeight()) ||
                    (newCard.getHeight() > players.get(turn).getHand().top().getHeight() &&
                            newCard.getHeight() < players.get(turn).getHand().iterator().next().getHeight())){
                goodGuess = false;
            }else{
                goodGuess = true;
                players.get(turn).addPoint();
            }
        }
        if(option == 3){
            if(newCard.getHeight() == players.get(turn).getHand().top().getHeight() ||
                    newCard.getHeight() == players.get(turn).getHand().getFirstItem().getHeight() ) {
                goodGuess = true;
                players.get(turn).addPoint();
            }else{
                goodGuess = false;
            }
        }
    }


    /**
     * Method that checks if the player is eligible for the bonus question, has 3 cards of different suits.
     * @param player the player
     */
    public boolean threeSuitsHand(Player player){
        int clubs = 0;
        int spades = 0;
        int diamonds = 0;
        int hearts = 0;
        for(int i = 0; i < 3; i++) {
            if(player.getHand().cardAtIndex(i).getSuit() == Card.Suit.CLUBS)
                clubs++;

            if(player.getHand().cardAtIndex(i).getSuit() == Card.Suit.SPADES)
                spades++;

            if(player.getHand().cardAtIndex(i).getSuit() == Card.Suit.DIAMONDS)
                diamonds++;

            if(player.getHand().cardAtIndex(i).getSuit() == Card.Suit.HEARTS)
                hearts++;
        }
        if (hearts < 2 && clubs < 2 && spades < 2 && diamonds < 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method that checks players' answers for the 4th round.
     * @param newCard a card that is drawn from the deck
     */
    public void checkRound4(Card newCard, Player player) {
        if(option == 1) {
            for(int i = 0; i < 3; i++) {
                if (newCard.getSuit() == players.get(turn).getHand().cardAtIndex(i).getSuit()) {
                    goodGuess = true;
                    players.get(turn).addPoint();
                } else {
                    goodGuess = false;
                }
            }
        }

        if(option == 2) {
            for(int i = 0; i < 3; i++) {
                if (newCard.getSuit() == players.get(turn).getHand().cardAtIndex(i).getSuit()) {
                    goodGuess = false;
                } else {
                    goodGuess = true;
                    players.get(turn).addPoint();
                }
            }
        }

        if(option == 3) {
            boolean check = false;
            if (threeSuitsHand(player)) {
                for (int i = 0; i < 3; i++) {
                    if (newCard.getSuit() == players.get(turn).getHand().cardAtIndex(i).getSuit()) {
                        goodGuess = false;
                        players.get(turn).bonus(false);
                        check = true;
                    }
                }
                if (!check) {
                    goodGuess = true;
                    players.get(turn).bonus(true);
                }
            }
        }
        option = 0;
    }

    /**
     * Method that checks players' answers for all rounds.
     * @param newCard a card that is drawn from the deck
     */
    public void checkIfRight(Card newCard){
        if(round == 1 && option == 1){
            if(newCard.getColourInt() == 0){
                goodGuess = true;
                players.get(turn).addPoint();
            }else{
                goodGuess = false;
            }
        }
        if(round == 1 & option == 2){
            if(newCard.getColourInt() == 1){
                goodGuess = true;
                players.get(turn).addPoint();
            }else{
                goodGuess = false;
            }
        }
        if(round == 2) {
            checkRound2(newCard);
        }
        if(round == 3) {
            checkRound3(newCard);
        }
        if(round == 4) {
            checkRound4(newCard, players.get(turn));
        }
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
        turn = 0;
        round = 1;
        option =0;
        partGame = 1;
        cardChosen = true;
        goodGuess = false;
        start = false;
    }

    /**
     * If the movable card updates this updates too
     */
    @Override
    public void update(Observable observable, Object message) {
        setChanged();
        notifyObservers();
    }

    /**
     * Getter of the player's turn
     * @return player's turn
     */
    public int getTurn(){
        return turn;
    }

    /**
     * Getter of the round number
     * @return round number
     */
    public int getRound(){
        return round;
    }

    public void optionOneChosen(){
        option = 1;
    }

    public void optionTwoChosen(){
        option = 2;
    }

    public void optionThreeChosen(){
        option = 3;
    }

    public boolean getCardChosen(){
        return cardChosen;
    }

    public boolean didHeGuessRight(){
        return goodGuess;
    }

    public boolean isStarted(){
        return start;
    }

    /**
     * Getter of the part of the game
     * @return part of the game
     */
    public int getPartGame(){
        return partGame;
    }

    /**
     * Method that gives the winner of the game.
     * @return the winner of the game or -1 if it draw
     */
    public static int getWinner() {
        int bestResult = -1;
        int winner = -1;
        int counter = 0;
            for (int i = 0; i < 4; i++) {
                if (players.get(i).getPoints() > bestResult) {
                    bestResult = players.get(i).getPoints();
                    winner = i;
                }
            }
            for (int i = 0; i < 4; i++) {
                if (players.get(i).getPoints() == bestResult) {
                    counter++;
                }
            }
            if (counter > 1) {
                winner = -1;
            }
        return winner;
    }
}

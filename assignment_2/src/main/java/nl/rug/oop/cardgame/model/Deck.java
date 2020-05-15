package nl.rug.oop.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

public class Deck extends Observable {
    private ArrayList<Card> Cards = new ArrayList<>();
    private ArrayList<Card> usedCards;
    private static final String[] suits = { "Hearts", "Spades", "Diamonds", "Clubs" };
    private static final String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

    public void newDeck() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                Card card = new Card(ranks[i], suits[j]);
                Cards.add(card);
            }
        }
    }

    public void printDeck() {
        for (Card card : Cards) {
            System.out.println(card.toString());
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(Cards);
    }

    public void takeCard(Player player) {
        player.receiveCard(Cards.get(0));
        Cards.remove(0);
        setChanged();
        notifyObservers();
    }

    public int getCardsNr() {
        return Cards.size();
    }
}

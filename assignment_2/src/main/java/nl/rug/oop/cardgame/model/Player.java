package nl.rug.oop.cardgame.model;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> Hand = new ArrayList<>();

    public void receiveCard(Card card) {
        Hand.add(card);
    }
}



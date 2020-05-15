package nl.rug.oop.cardgame.model;


public class Card {
    private String rank;
    private String suit;


    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format("%s %s", rank, suit);
    }
}





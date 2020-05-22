package cardgame.model;

import cardgame.model.card.Card;
import cardgame.util.Emptiable;
import cardgame.util.Sized;

import java.util.Stack;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Pile of cards which has all cards open
 */
public class Hand implements Emptiable, Sized, Iterable<Card> {

    private Stack<Card> hand;

    /**
     * Create a new empty hand
     */
    public Hand() {
        hand = new Stack<>();
    }

    /**
     * Put a card on the hand
     */
    public void put(Card card) {
        hand.push(card);
    }

    /**
     * Remove all cards from the hand
     */
    public Stack<Card> emptyHand() {
        Stack<Card> retVal = hand;
        hand = new Stack<>();
        return retVal;
    }

    /**
     * Returns the top card of the discard pile, or null if none is present
     */
    public Card top() {
        if (!isEmpty()) {
            return hand.peek();
        }
        return null;
    }

    /**
     * Allows iterating over this discard pile without changing it
     * Does not support remove, so will throw an UnsuportedOperationException
     */
    private class ConcreteHandIterator implements Iterator<Card> {

        private ListIterator<Card> backing;

        /**
         * Create an iterator for this immutable hand using the
         * iterator of the hand it protects
         */
        public ConcreteHandIterator() {
            backing = hand.listIterator(0);
        }

        /**
         * Find the next card in this hand
         */
        @Override
        public Card next() {
            return backing.next();
        }

        /**
         * Check if all cards have been looked at.
         */
        @Override
        public boolean hasNext() {
            return backing.hasNext();
        }

        /**
         * Removes a card from the hand
         */
        @Override
        public void remove() {
            backing.remove();
        }
    }

    /**
     * Returns an iterator which visits the cards in this discard pile
     * from BOTTOM to TOP, not from top to bottom.
     */
    @Override
    public Iterator<Card> iterator() {
        return new ConcreteHandIterator();
    }

    /**
     * Check the number of cards in this pile
     */
    @Override
    public int size() {
        return hand.size();
    }

    /**
     * Check if there are any cards left in the hand
     */
    @Override
    public boolean isEmpty() {
        return hand.isEmpty();
    }

    /**
     * Remove all the cards in the hand
     */
    @Override
    public void empty() {
        hand.clear();
    }

}

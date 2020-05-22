package cardgame.model.deck;

import cardgame.model.card.Card;

/**
 * A deck that has all possible cards
 */
public class CompleteDeck extends AbstractDeck {

    /**
     * Add all possible cards
     */
    @Override
    protected void addCards() {
        for (Card card : Card.values())
            addOnTop(card);
    }
}

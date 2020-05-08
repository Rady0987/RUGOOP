package nl.rug.oop.rpg.utility;

import nl.rug.oop.rpg.game.Player;

/**
 * An interface that classes can implement so that they can be interactable
 */
public interface Interactable {
    void interact(Player player);
}

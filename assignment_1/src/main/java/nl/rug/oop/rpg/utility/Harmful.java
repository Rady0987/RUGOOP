package nl.rug.oop.rpg.utility;

/**
 * An interface that classes can implement so that they can attack the player.
 */

import nl.rug.oop.rpg.game.Player;

public interface Harmful {
    void attack(Player player);
}

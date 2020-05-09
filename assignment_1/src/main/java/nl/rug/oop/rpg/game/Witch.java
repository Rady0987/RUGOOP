package nl.rug.oop.rpg.game;

import nl.rug.oop.rpg.game.NPC;
import nl.rug.oop.rpg.game.Player;

/**
 * A witch class.
 */

public class Witch extends NPC {
    private int playerBonus;

    /**
     * Constructor
     *
     * @param name Name of the NPC.
     * @param description Short description of the NPC.
     * @param reply A sentence that the NPC says.
     * @param health Initial HitPoints of the NPC.
     * @param attackDamage The attack damage of the NPC.
     * @param lifeState True if the NPC is alive, becomes False if it dies.
     * @param playerBonus The amount of attack damage granted to the player.
     * @param interactState Initialized with 0, becomes 1 after one interaction with the NPCs.
     */
    public Witch(String name, String description, String reply, int health, int attackDamage, boolean lifeState, int playerBonus, boolean interactState) {
        super(name, description, reply, health, attackDamage, lifeState,false);
        this.playerBonus = playerBonus;
    }

    /**
     * Method that adds damage points to the player.
     * @param player the name of player
     */
    public void damageUpgrade(Player player) {
        player.incDamage(playerBonus);
        System.out.println("Your damage increased with " + playerBonus + " points!");
        interactState = true;
    }
}

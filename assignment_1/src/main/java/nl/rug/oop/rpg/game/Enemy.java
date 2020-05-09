package nl.rug.oop.rpg.game;

import nl.rug.oop.rpg.game.NPC;
import nl.rug.oop.rpg.game.Player;
import nl.rug.oop.rpg.utility.Attackable;
import nl.rug.oop.rpg.utility.Harmful;

/**
 * An enemy class
 */

public class Enemy extends NPC implements Attackable, Harmful {

    /**
     * Constructor
     *
     * @param name Name of the Enemy
     * @param description Short description of the enemy
     * @param reply A sentence that the NPC says
     * @param health Initial HitPoints of the enemy
     * @param attackDamage Damage the enemy deals
     * @param lifeState True if the NPC is alive, becomes False if it dies
     * @param interactState Initialized with 0, becomes 1 after one interaction with the NPCs.
     */
    public Enemy(String name, String description, String reply, int health, int attackDamage, boolean lifeState, boolean interactState) {
        super(name, description, reply, health, attackDamage, lifeState, false);
    }

    /**
     * Method that subtracts hitpoints in case the NPC is attacked.
     */
    public void damage(int damageDealt) {
        health -= damageDealt;
        System.out.println("You attacked " + name + ", " + name + "'s health =" + health);
        if(health <= 0) {
            System.out.println(description + " was defeat! You won the battle!");
            lifeState = false;
        }
    }

    /**
     * Method allowing the enemy NPC attack the player, subtracting hit points.
     * @param player the name of the attacked player.
     */
    public void attack(Player player) {
        player.damage(attackDamage);
    }
}

package nl.rug.oop.rpg;
/**
 * An enemy class
 */
public class Enemy extends NPC {

    /**
     * Constructor
     *
     * @param name Name of the Enemy
     * @param description Short description of the enemy
     * @param reply A sentence that the NPC says
     * @param health Initial HitPoints of the enemy
     * @param attackDamage Damage the enemy deals
     */

    public Enemy(String name, String description, String reply, int health, int attackDamage) {
        super(name, description, reply, health, attackDamage);
    }

}

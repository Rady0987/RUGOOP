package nl.rug.oop.rpg;
/**
 * An enemy class
 */
public class Enemy extends NPC implements Attackable{
    private int attackDamage;

    /**
     * Constructor
     *
     * @param name Name of the Paladin
     * @param description Short description of the enemy
     * @param health Initial HitPoints of the enemy
     * @param attackDamage Damage the enemy deals
     */

    public Enemy(String name, String description, int health, int attackDamage) {
        super(name, description, health);
        this.attackDamage = attackDamage;
    }

    /**
     * Method allowing the enemy NPC attack the player, subtracting hit points
     *
     * @param player the name of the attacked player
     */

    public void attack(Player player) {
        player.health =- attackDamage;
    }
}

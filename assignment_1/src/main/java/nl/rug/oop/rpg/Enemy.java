package nl.rug.oop.rpg;
/**
 * An enemy class
 */
public class Enemy extends NPC implements Attackable{
    private int attackDamage;

    /**
     * Constructor
     *
     * @param description Short describtion of the enemy
     * @param health Initial HitPoints of the enemy
     * @param attackDamage Damage the enemy deals
     */

    public Enemy(String description, int health, int attackDamage) {
        super(description, health);
        this.attackDamage = attackDamage;
    }

    /**
     * Method allowing the player to attack enemies, subtracting hit points
     *
     * @param player the name of the attacked player
     */

    public void attack(Player player) {
        player.health =- attackDamage;
    }
}

package nl.rug.oop.rpg;
/**
 * An enemy class
 */

public class Enemy extends NPC implements Attackable{

    /**
     * Constructor
     *
     * @param name Name of the Enemy
     * @param description Short description of the enemy
     * @param reply A sentence that the NPC says
     * @param health Initial HitPoints of the enemy
     * @param attackDamage Damage the enemy deals
     * @param lifeState True if the NPC is alive, becomes False if it dies
     */
    public Enemy(String name, String description, String reply, int health, int attackDamage, boolean lifeState) {
        super(name, description, reply, health, attackDamage, lifeState);
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
     * Method allowing the enemy NPC attack the player, subtracting hit points
     * @param player the name of the attacked player
     */
    public void attack(Player player) {
        player.damage(attackDamage);
    }
}

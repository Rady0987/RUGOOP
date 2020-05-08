package nl.rug.oop.rpg.game;

/**
 * A paladin class.
 */

public class Paladin extends NPC {

    /**
     * Constructor
     *
     * @param name Name of the NPC.
     * @param description Short description of the NPC.
     * @param reply A sentence that the NPC says.
     * @param health      Initial HitPoints of the NPC.
     * @param attackDamage The attack damage of the NPC.
     * @param lifeState True if the NPC is alive, becomes False if it dies.
     */
    public Paladin(String name, String description, String reply, int health, int attackDamage, boolean lifeState) {
        super(name, description, reply, health, attackDamage, lifeState);
    }

    /**
     * Method allowing the enemy Paladin heal the player, adding hit points.
     * @param player the name of the healed player.
     */
    public void heal (Player player) {
        player.addHealth(5);
    }
}

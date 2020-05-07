package nl.rug.oop.rpg;
/**
 * A witch class
 */
public class Witch extends NPC {

    /**
     * Constructor
     *
     * @param name        Name of the NPC
     * @param description Short description of the NPC
     * @param reply A sentence that the NPC says
     * @param health      Initial HitPoints of the NPC
     * @param attackDamage The attack damage of the NPC
     * @param lifeState True if the NPC is alive, becomes False if it dies
     */
    public Witch(String name, String description, String reply, int health, int attackDamage, boolean lifeState) {
        super(name, description, reply, health, attackDamage, lifeState);
    }

    /**
     * Method that adds damage points to the player.
     * @param player the name of player
     */
    public void damageUpgrade(Player player) {
        player.attackDamage =+ 5;
    }
}

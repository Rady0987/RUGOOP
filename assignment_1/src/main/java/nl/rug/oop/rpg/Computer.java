package nl.rug.oop.rpg;
/**
 * A computer class
 */

public class Computer extends NPC {

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
    public Computer(String name, String description, String reply, int health, int attackDamage, boolean lifeState) {
        super(name, description, reply, health, attackDamage, lifeState);
    }
}

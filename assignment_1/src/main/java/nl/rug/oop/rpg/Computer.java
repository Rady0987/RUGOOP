package nl.rug.oop.rpg;

public class Computer extends NPC {

    /**
     * Constructor
     *
     * @param name        Name of the NPC
     * @param description Short description of the NPC
     * @param reply A sentence that the NPC says
     * @param health      Initial HitPoints of the NPC
     * @param attackDamage The attack damage of the NPC
     */
    public Computer(String name, String description, String reply, int health, int attackDamage) {
        super(name, description, reply, health, attackDamage);
    }
}

package nl.rug.oop.rpg;

public class Computer extends NPC {

    /**
     * Constructor
     *
     * @param name        Name of the NPC
     * @param description Short description of the NPC
     * @param health      Initial HitPoints of the NPC
     */
    public Computer(String name, String description, int health) {
        super(name, description, health);
    }
}

package nl.rug.oop.rpg;
/**
 * A NPC class
 */
abstract class NPC implements Inspectable, Interactable, Attackable {
    protected String name;
    protected String description;
    protected int health;
    /**
     * Constructor
     *
     * @param name Name of the NPC
     * @param description Short description of the NPC
     * @param health Initial HitPoints of the NPC
     */
    public NPC(String name,String description, int health) {
        this.name = name;
        this.description = description;
        this.health = health;
    }

    /**
     * Method that prints the name of the NPC, when inspected.
     */

    public void inspect() {
        System.out.println(name);
    }

    /**
     * Method that subtracts hitpoints in case the NPC is attacked.
     */

    public void damage() {
        System.out.println(description + "is being wounded");
        health--;
        if(health == 0) {
            System.out.println(description + "died!");
        }
    }

    /**
     * Method that prints the description of the NPC.
     */

    public void interact(Player player) {
        System.out.println(description);
    }
}

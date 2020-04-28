package nl.rug.oop.rpg;
/**
 * A NPC class
 */
public class NPC implements Inspectable, Interactable, Attackable {
    protected String description;
    protected int health;
    /**
     * Constructor
     *
     * @param description Short describtion of the NPC
     * @param health Initial HitPoints of the NPC
     */
    public NPC(String description, int health) {
        this.description = description;
        this.health = health;
    }

    public void inspect() {
        System.out.println(description);
    }

    public void damage() {
        System.out.println(description + "is being wounded");
        health--;
    }

    public void interact(Player player) {
        System.out.println(description);
    }
}

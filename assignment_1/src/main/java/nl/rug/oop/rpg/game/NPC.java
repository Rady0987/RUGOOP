package nl.rug.oop.rpg.game;
import nl.rug.oop.rpg.utility.Inspectable;
import nl.rug.oop.rpg.utility.Interactable;

import java.io.Serializable;
/**
 * A NPC class.
 */

abstract class NPC implements Inspectable, Interactable, Serializable {
    protected String name;
    protected String description;
    protected String reply;
    protected int health;
    protected int attackDamage;
    protected boolean lifeState;
    private static final long serialVersionUID = 42L;

    /**
     * Constructor
     *
     * @param name Name of the NPC.
     * @param description Short description of the NPC.
     * @param reply A sentence that the NPC says.
     * @param health Initial HitPoints of the NPC.
     * @param attackDamage The attack damage of the NPC.
     * @param lifeState True if the NPC is alive, becomes False if it dies.
     */
    public NPC(String name, String description, String reply, int health, int attackDamage, boolean lifeState) {
        this.name = name;
        this.description = description;
        this.reply = reply;
        this.health = health;
        this.attackDamage = attackDamage;
        this.lifeState = lifeState;
    }

    /**
     * Method that prints the name of the NPC, when inspected.
     */
    public void inspect() {
        if (lifeState) {
            System.out.println(description);
        } else {
            System.out.println(description + " (DEAD)");
        }
    }

    /**
     * Method that prints the description of the NPC.
     * @param player the name of player.
     */
    public void interact(Player player) {
        if (lifeState) {
            System.out.println(name + " (" + description + ", HP: "+ health + ", DMG: " +attackDamage + ")" + reply);
        } else {
            System.out.println("You cannot interact with " + name );
        }
    }

    /**
     * @return the health of the NPC.
     */
    public int getHealth() {
        return health;
    }

    /**
     * @return the lifeState of the NPC.
     */
    public boolean getLifeState() {
        return lifeState;
    }
}

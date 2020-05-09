package nl.rug.oop.rpg.game;
import nl.rug.oop.rpg.utility.Inspectable;
import nl.rug.oop.rpg.utility.Interactable;
import java.io.Serializable;

/**
 * A door class.
 */

public abstract class Door implements Inspectable, Interactable, Serializable {
	private String description;
	private int roomBehind;
	protected boolean doorOpen;
	protected int strength;
	protected int attackDamage;
	private static final long serialVersionUID = 42L;

	/**
	 * Constructor
	 *
	 * @param description Short description of the door.
	 * @param roomBehind The room that is behind that door.
	 * @param strength The hitpoints of the door.
	 * @param attackDamage The damage door deals to the player.
	 */
	public Door(String description, int roomBehind, int strength, int attackDamage) {
		this.description = description;
		this.roomBehind = roomBehind;
		this.strength = strength;
		this.attackDamage = attackDamage;
		if(strength > 0) {
			doorOpen = false;
		} else {
			doorOpen = true;
		}
	}

	/**
	 * Prints the description of the door.
	 */
	public void inspect() {
		System.out.println(description);
	}

	/**
	 * If the door is open then changes the location of the player to next room.
	 * @param player The name of the player.
	 */
	public void interact(Player player) {
		if (doorOpen == true ){
			player.changeLocation(roomBehind);
		}
	}

	/**
     * @return whether the door is open.
     */
    public boolean isDoorOpen() {
        return doorOpen;
    }

    /**
     * @return the strength of the door.
     */
    public int getStrength() {
        return strength;
    }

}
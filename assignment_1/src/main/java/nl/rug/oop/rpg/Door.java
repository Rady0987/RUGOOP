package nl.rug.oop.rpg;
import java.io.Serializable;
/**
 * A door class
 */

abstract class Door implements Inspectable, Interactable, Serializable {
	private String description;
	private int roomBehind;
	protected boolean doorOpen;
	protected int strength;
	protected int attackDamage;
	private static final long serialVersionUID = 42L;

	/**
	 * Constructor
	 *
	 * @param description Short description of the door
	 * @param roomBehind The room that is behind that door
	 */
	public Door(String description, int roomBehind, int strength, int attackDamage) {
		this.description = description;
		this.roomBehind = roomBehind;
		this.strength = strength;
		this.attackDamage = attackDamage;
		if(strength > 0){
			doorOpen = false;
		}else{
			doorOpen = true;
		}
	}

	public void inspect() {
		System.out.println(description);
	}

	public void interact(Player player) {
		if(doorOpen == true ){
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
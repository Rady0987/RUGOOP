package nl.rug.oop.rpg;
/**
 * A door class
 */

abstract class Door implements Inspectable, Interactable {
	private String description;
	private int roomBehind;

	/**
	 * Constructor
	 *
	 * @param description Short description of the door
	 * @param roomBehind The room that is behind that door
	 */
	public Door(String description, int roomBehind) {
		this.description = description;
		this.roomBehind = roomBehind;
	}

	public void inspect() {
		System.out.println(description);
	}

	public void interact(Player player) {
		player.changeLocation(roomBehind);
	}
}
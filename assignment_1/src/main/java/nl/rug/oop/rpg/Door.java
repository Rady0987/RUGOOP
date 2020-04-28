package nl.rug.oop.rpg;
/**
 * A door class
 */
public class Door implements Inspectable, Interactable {
	private String description;
	private int roomBehind;

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
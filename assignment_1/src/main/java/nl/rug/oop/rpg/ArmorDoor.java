package nl.rug.oop.rpg;
/**
 * A ArmorDoor class
 */
public class ArmorDoor extends Door {
    private int armorBonus;

    /**
     * Constructor
     *
     * @param description Short description of the door
     * @param roomBehind  The room that is behind that door
     */
    public ArmorDoor(String description, int roomBehind) {
        super(description, roomBehind);
    }

    /**
     * Method that adds armor to the player.
     * @param player the name of player
     */
    public void addArmor(Player player) {
        player.plusArmor(armorBonus);
    }
}

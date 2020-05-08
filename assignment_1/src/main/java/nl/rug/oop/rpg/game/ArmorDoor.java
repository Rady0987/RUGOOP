package nl.rug.oop.rpg.game;

/**
 * A ArmorDoor class.
 */

public class ArmorDoor extends Door {
    private int armorBonus;

    /**
     * Constructor
     *
     * @param description Short description of the door.
     * @param roomBehind  The room that is behind that door.
     * @param armorBonus The armor given to player when opening.
     */
    public ArmorDoor(String description, int roomBehind, int armorBonus) {
        super(description, roomBehind, 0, 0);
        this.armorBonus = armorBonus;
    }

    /**
     * Method that adds armor to the player.
     * @param player the name of player.
     */
    public void addArmor(Player player) {
        player.plusArmor(armorBonus);
    }
}

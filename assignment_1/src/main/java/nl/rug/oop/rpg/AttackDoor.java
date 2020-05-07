package nl.rug.oop.rpg;
/**
 * An AttackDoor class
 */

public class AttackDoor extends Door {

    /**
     * Constructor
     *
     * @param description Short description of the door
     * @param roomBehind  The room that is behind that door
     */
    public AttackDoor(String description, int roomBehind) {
        super(description, roomBehind);
    }
}

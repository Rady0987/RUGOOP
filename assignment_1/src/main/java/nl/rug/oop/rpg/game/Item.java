package nl.rug.oop.rpg.game;
import nl.rug.oop.rpg.utility.Inspectable;

/**
 * An item class.
 */

public class Item implements Inspectable {
    private String name;
    private String description;
    private int attribute;


    /**
     * Constructor
     * @param name The name of the item.
     * @param description The description of the item.
     * @param attribute The properties of the item.
     */

    public Item(String name, String description, int attribute) {
        this.name = name;
        this.description = description;
        this.attribute = attribute;
    }

    /**
     * Method that prints the name and the description of the item.
     */
    public void inspect() {
        System.out.println(name + ": " +description);
    }
}
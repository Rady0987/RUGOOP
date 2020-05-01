package nl.rug.oop.rpg;
/**
 * An item class
 */
public class Item {
    private String name;
    private String description;
    private int attribute;


    /**
     * Constructor
     * @param name The name of the item
     * @param attribute The properties of the item
     */

    public Item(String name, String description, int attribute) {
        this.name = name;
        this.description = description;
        this.attribute = attribute;
    }
}

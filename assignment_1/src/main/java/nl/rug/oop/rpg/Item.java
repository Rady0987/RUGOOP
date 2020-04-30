package nl.rug.oop.rpg;
/**
 * An item class
 */
public class Item {
    private String name;
    private int attribute;


    /**
     * Constructor
     *
     * @param name The name of the item
     * @param attribute The properties of the item
     */

    public Item(String name, int attribute) {
        this.name = name;
        this.attribute = attribute;
    }
}

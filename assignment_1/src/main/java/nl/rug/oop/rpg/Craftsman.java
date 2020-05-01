package nl.rug.oop.rpg;
import java.util.ArrayList;
/**
 * A Craftsman class
 */
public class Craftsman extends NPC {
    private ArrayList<Item> items;
    /**
     * Constructor
     * @param name        Name of the NPC
     * @param description Short description of the NPC
     * @param health      Initial HitPoints of the NPC
     */
    public Craftsman(String name, String description, int health) {
        super(name, description, health);
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

}

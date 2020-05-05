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
     * @param reply A sentence that the NPC says
     * @param health      Initial HitPoints of the NPC
     * @param attackDamage The attack damage of the NPC
     */
    public Craftsman(String name, String description, String reply, int health, int attackDamage) {
        super(name, description, reply, health, attackDamage);
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

}
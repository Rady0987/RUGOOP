package nl.rug.oop.rpg.game;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A Craftsman class
 */

public class Craftsman extends NPC {
    private ArrayList<Item> items = new ArrayList<>();
    private static final String Choise_Message = "\t Great choice! Good luck in your future battles!";
    /**
     * Constructor
     *
     * @param name Name of the NPC.
     * @param description Short description of the NPC.
     * @param reply A sentence that the NPC says.
     * @param health Initial HitPoints of the NPC.
     * @param attackDamage The attack damage of the NPC.
     * @param lifeState True if the NPC is alive, becomes False if it dies.
     */
    public Craftsman(String name, String description, String reply, int health, int attackDamage, boolean lifeState) {
        super(name, description, reply, health, attackDamage, lifeState);
        craftItems();
    }

    /**
     * Method that initialize the items in the ArrayList of items.
     */
    public void craftItems () {
        Item item1 = new Item("Shadow Blade", "Increases your damage with 5 points", 5);
        items.add(item1);
        Item item2 = new Item("Crimson Guard","Increases your armour with 8 points", 8 );
        items.add(item2);
        Item item3 = new Item("Blood Stone","Increases your health with 5 points", 5 );
        items.add(item3);
    }

    /**
     * Method allowing the player to inspect the craftsman's items.
     * @param player The name of the player.
     */
    public void inspectItems(Player player) {
        System.out.println("\n");
        System.out.println("You can choose one of this items to be in your arsenal!");
        int step = 0;
        for(Item item : items) {
            System.out.print("\t (" + step + ")");
            item.inspect();
            step++;
        }
        itemChoose(player);
    }

    /**
     * Method allowing the player to choose one of the craftsman's items.
     * @param player The name of the player.
     */
    public void itemChoose(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Have you decided, my dear friend? (Enter the number)");
        int selected = scanner.nextInt();
        if (selected == 0) {
            player.incDamage(5);
            System.out.println(Choise_Message);
        }
        if (selected == 1) {
            player.plusArmor(8);
            System.out.println(Choise_Message);
        }
        if (selected == 2) {
            player.addHealth(5);
            System.out.println(Choise_Message);
        }
        if(selected > items.size()-1)
            System.out.println("Oh, looks like you don't need anything. (Invalid item)");
    }
}

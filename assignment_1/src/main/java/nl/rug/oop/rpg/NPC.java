package nl.rug.oop.rpg;
/**
 * A NPC class
 */
abstract class NPC implements Inspectable, Interactable {
    protected String name;
    protected String description;
    protected String reply;
    protected int health;
    protected int attackDamage;
    /**
     * Constructor
     *
     * @param name Name of the NPC
     * @param description Short description of the NPC
     * @param reply A sentence that the NPC says
     * @param health Initial HitPoints of the NPC
     * @param attackDamage The attack damage of the NPC
     */
    public NPC(String name, String description, String reply, int health, int attackDamage) {
        this.name = name;
        this.description = description;
        this.reply = reply;
        this.health = health;
        this.attackDamage = attackDamage;
    }

    /**
     * Method that prints the name of the NPC, when inspected.
     */

    public void inspect() {
        System.out.println(description);
    }

    /**
     * Method allowing the enemy NPC attack the player, subtracting hit points
     *
     * @param player the name of the attacked player
     */

    public void attack(Player player) {
        player.damage(attackDamage);
    }

    /**
     * Method that subtracts hitpoints in case the NPC is attacked.
     */

    public void damage() {
        System.out.println(description + "is being wounded");
        health--;
        if(health == 0) {
            System.out.println(description + "died!");
        }
    }

    /**
     * Method that prints the description of the NPC.
     */

    public void interact(Player player) {
        System.out.println(name + " (" + description + ")" + reply);
    }
}

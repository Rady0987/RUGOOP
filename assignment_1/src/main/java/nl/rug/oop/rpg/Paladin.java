package nl.rug.oop.rpg;

public class Paladin extends NPC {
    /**
     * Constructor
     *
     * @param name Name of the NPC
     * @param description Short description of the NPC
     * @param reply A sentence that the NPC says
     * @param health      Initial HitPoints of the NPC
     * @param attackDamage The attack damage of the NPC
     */
    public Paladin(String name, String description, String reply, int health, int attackDamage) {
        super(name, description, reply, health, attackDamage);
    }

    /**
     * Method allowing the enemy Paladin heal the player, adding hit points
     *
     * @param player the name of the healed player
     */

    public void heal (Player player) {
        player.addHealth(5);
        System.out.println(name + "healed you, now you have " + player.getHealth() + " hitpoints");
    }
}

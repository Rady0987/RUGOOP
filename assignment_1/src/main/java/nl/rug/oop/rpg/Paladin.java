package nl.rug.oop.rpg;

public class Paladin extends NPC {
    /**
     * Constructor
     *
     * @param name Name of the NPC
     * @param description Short description of the NPC
     * @param health      Initial HitPoints of the NPC
     */
    public Paladin(String name, String description, int health) {
        super(name, description, health);
    }

    /**
     * Method allowing the enemy Paladin heal the player, adding hit points
     *
     * @param player the name of the healed player
     */

    public void heal (Player player) {
        player.health =+ 2;
        System.out.println(name + "healed you, now you have " + player.health + " hitpoints");
    }
}

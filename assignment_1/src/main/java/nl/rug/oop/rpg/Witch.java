package nl.rug.oop.rpg;

public class Witch extends NPC {
    /**
     * Constructor
     *
     * @param name        Name of the NPC
     * @param description Short description of the NPC
     * @param health      Initial HitPoints of the NPC
     */
    public Witch(String name, String description, int health) {
        super(name, description, health);
    }

    public void damageUpgrade(Player player) {
        player.attackDamage =+ 5;
    }
}

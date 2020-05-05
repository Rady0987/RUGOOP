package nl.rug.oop.rpg;

public class Witch extends NPC {
    /**
     * Constructor
     *
     * @param name        Name of the NPC
     * @param description Short description of the NPC
     * @param reply A sentence that the NPC says
     * @param health      Initial HitPoints of the NPC
     * @param attackDamage The attack damage of the NPC
     */
    public Witch(String name, String description, String reply, int health, int attackDamage) {
        super(name, description, reply, health, attackDamage);
    }

    public void damageUpgrade(Player player) {
        player.attackDamage =+ 5;
    }
}

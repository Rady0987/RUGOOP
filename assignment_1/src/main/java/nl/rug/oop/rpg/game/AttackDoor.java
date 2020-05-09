package nl.rug.oop.rpg.game;

import nl.rug.oop.rpg.utility.Attackable;
import nl.rug.oop.rpg.utility.Harmful;
/**
 * An AttackDoor class.
 */

public class AttackDoor extends Door implements Attackable, Harmful {

    /**
     * Constructor
     *
     * @param description Short description of the door.
     * @param roomBehind  The room that is behind that door.
     * @param strength The hitpoints of the door.
     * @param attackDamage The damage door deals to the player.
     */
    public AttackDoor(String description, int roomBehind, int strength, int attackDamage) {
        super(description, roomBehind, strength, attackDamage);
    }

    /**
     * Method allowing the door attack the player, subtracting hit points
     * @param damageDealt The amount of damage dealt to the player.
     */
    public void damage(int damageDealt){
		strength -= damageDealt;
		System.out.println("You attacked the door! He still has a strength of:" + strength);
		if(strength < 1){
			doorOpen = true;
			System.out.println("You have successfully beaten the door!");
		}
	}
    
    /**
     * Method allowing the door attack the player, subtracting hit points.
     * @param player the name of the attacked player.
     */
    public void attack(Player player) {
        player.damage(attackDamage);
    }
}

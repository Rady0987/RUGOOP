package nl.rug.oop.rpg;
/**
 * An AttackDoor class
 */

public class AttackDoor extends Door implements Attackable {

    /**
     * Constructor
     *
     * @param description Short description of the door
     * @param roomBehind  The room that is behind that door
     */
    public AttackDoor(String description, int roomBehind, int strength, int attackDamage) {
        super(description, roomBehind, strength, attackDamage);
    }

    public void damage(int damageDealt){
		strength -= damageDealt;
		System.out.println("You attacked the door! He still has a strength of:" + strength);
		if(strength < 1){
			doorOpen = true;
			System.out.println("You have succesfully beaten the door!");
		}
	}
    
    /**
     * Method allowing the door attack the player, subtracting hit points
     * @param player the name of the attacked player
     */
    public void attack(Player player) {
        player.damage(attackDamage);
    }
}

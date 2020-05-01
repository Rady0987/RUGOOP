package nl.rug.oop.rpg;
/**
 * A player class
 */
public class Player implements Attackable {
	private String name;
	private int location;
	protected int health;
	protected int attackDamage;
	private static int DEFAULT_LOCATION = 0;

	/**
	 * Constructor
	 *
	 * @param name The name of the player
	 * @param health Initial HitPoints of the player
	 * @param attackDamage Damage the player deals to NPCs
	 */

	public Player(String name, int health, int attackDamage) {
		this.name = name;
		this.location = DEFAULT_LOCATION;
		this.health = health;
		this.attackDamage = attackDamage;
	}

	/**
	 * Method that returns the current location of the player.
	 */

	public int location() {
		return location;
	}

	/**
	 * Method allowing the player to attack enemies, subtracting hitpoints.
	 *
	 * @param enemy the name of the attacked enemy
	 */

	public void attack(Enemy enemy) {
		System.out.println(name + "attacks" + enemy.description);
		enemy.health =- attackDamage;
	}

	/**
	 * Method that modifies the current location of the player.
	 */

	public void changeLocation(int location){
		this.location = location;
	}

	/**
	 * Method that subtracts hitpoints in case the player is attacked.
	 */

	public void damage() {
		System.out.println("You are being wounded");
		health--;
	}
	
}
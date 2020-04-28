package nl.rug.oop.rpg;
/**
 * A player class
 */
public class Player {
	private String name;
	private int location;
	protected int health;
	private int attackDamage;
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

	public int location() {
		return location;
	}

	/**
	 * Method allowing the player to attack enemies, subtracting hitpoints
	 *
	 * @param enemy the name of the attacked enemy
	 */

	public void attack(Enemy enemy) {
		System.out.println(name + "attacks" + enemy.description);
		enemy.health =- attackDamage;
	}

	public void changeLocation(int location){
		this.location = location;
	}
	
}
package nl.rug.oop.rpg;
/**
 * A player class
 */
public class Player {
	private String name;
	private int location;
	private int health;
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

	public int getLocation() {
		return location;
	}

	/**
	 * Method that returns the current location of the player.
	 */

	public int getHealth() {
		return health;
	}

	public void addHealth(int healthBonus) {
		health += healthBonus;
	}

	/**
	 * Method allowing the player to attack npcs, subtracting hitpoints.
	 *
	 * @param npc the attacked npc
	 */

	public void attack(NPC npc) {
		npc.health =- attackDamage;
		System.out.println("You attack " + npc.name + ", " + npc.name + "'s health =" + npc.health);
	}

	/**
	 * Method that modifies the current location of the player.
	 */

	public void changeLocation(int location){
		this.location = location;
	}


	public void damage(int damageDealt) {
		health -= damageDealt;
		System.out.println("You are being wounded, your current health = " + health);
		if(health == 0) {
			System.out.println("You died!");
		}
	}

}
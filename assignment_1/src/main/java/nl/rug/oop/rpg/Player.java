package nl.rug.oop.rpg;
/**
 * A player class
 */

public class Player implements Attackable{
	private String name;
	private int location;
	private int health;
	protected int attackDamage;
	private static int DEFAULT_LOCATION = 0;
	private int armor;

	/**
	 * Constructor
	 *
	 * @param name The name of the player
	 * @param health Initial HitPoints of the player
	 * @param attackDamage Damage the player deals
	 * @param armor Armor level of the Player
	 */
	public Player(String name, int health, int attackDamage, int armor) {
		this.name = name;
		this.location = DEFAULT_LOCATION;
		this.health = health;
		this.attackDamage = attackDamage;
		this.armor = armor;
	}

	/**
	 * @return the current location of the player.
	 */
	public int getLocation() {
		return location;
	}

	/**
	 * @return the current location of the player.
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Method that adds points to player's health.
	 * @param healthBonus the amount of points to be add
	 */
	public void addHealth(int healthBonus) {
		health += healthBonus;
	}

	/**
	 * Method allowing the player to attack npcs, subtracting hitpoints.
	 * @param enemy the attacked npc
	 */
	public void attack(Enemy enemy) {
		enemy.damage(attackDamage);
	}

	/**
	 * Method allowing the player to attack doors, subtracting hitpoints.
	 * @param door the attacked door
	 */
	public void attack(AttackDoor attackdoor){
		attackdoor.damage(attackDamage);
	}

	/**
	 * Method that modifies the current location of the player.
	 * @param location the new location
	 */
	public void changeLocation(int location){
		this.location = location;
	}

	/**
	 * Method that subtracts hitpoints in case the player is attacked and ends game if health < 0.
	 * @param damageDealt amount of the points subtracted
	 */
	public void damage(int damageDealt) {
		health -= damageDealt;
		System.out.println("You are being wounded, your current health = " + health);
		if(health <= 0) {
			System.out.println("\n");
			System.out.println("\t You died!\n" + "\t GAME OVER");
			System.exit(0);
		}
	}

	/**
	 * Method that adds armor points to the player.
	 * @param bonus the amount of points to be added
	 */
	public void plusArmor (int bonus){
		armor += bonus;
	}

	
}
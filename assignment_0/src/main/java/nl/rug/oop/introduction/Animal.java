package nl.rug.oop.introduction;
/***Models an animal with an age and energy level*/
public class Animal {
	private String name;
	private int energy;
	public Animal(String name, int energy) {
		this.name = name;
		this.energy = energy;
	}
	/*Makes the animal run*/
	public void run() {
		if(energy > 0) {
			System.out.println(name + ": Running!");
			energy--;
		}else{
			System.out.println(name + ": Out of energy!");
		}
	}

	/*Makes the animal eat*/
	public void eat() {
		System.out.println(name + ": Eating!");
		energy++;
	}

	/*Prints the hunger level*/
	public void printHungerLevel() {
		System.out.println(name + " energy level: " + energy);
	}

	/**
	 *Overloaded constructor
	 *
	 *@param name The name we want the animal to have
	 */
	public Animal(String name) {
		/* Calls the constructor above this one with a default energy level of 52 */
		this(name, 52);
	}
}
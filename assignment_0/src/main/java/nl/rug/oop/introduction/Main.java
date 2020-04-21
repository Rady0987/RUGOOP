package nl.rug.oop.introduction;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Animal[] animals;
		if(args.length == 0) {
			/* No arguments were provided */
			animals = initAnimals();
		}else{
			/* Initialise animals with names given in the command-line arguments */
			animals = initAnimals(args);
		}
		while(scanner.hasNextLine()) {
			String input = scanner.nextLine();
			for(Animal animal : animals) {
				if(input.equals("eat")) {
					/* Calls the eat() method of the object Animal */
					animal.eat();
				}else if(input.equals("run")) {
					/* Calls the run() method of the object Animal */
					animal.run();
				}
				/* Print the hunger level to verify whether something changed */
				animal.printHungerLevel();
			}
		}
	}
	/**
	 *Initialises an array of animals hardcoded in the program
	 *
	 *@returnAn array of animals
	 */
	private static Animal[] initAnimals() {
		/* Create a few different animals*/
		Animal zebra = new Animal("White Stripes", 20);
		Animal platypus = new Animal("Perry", 1000);
		Animal anteater = new Animal("Sybrand", 2);
		/* Put the animals in an array and return this array */
		Animal[] animals = {zebra, platypus, anteater};
		return animals;
	}

	/**
	 * Overloaded method initAnimals
	 *Will initialise an array of Animals with the names provided in the arguments
	 *
	 *@param args The command-line arguments.Contains the names of the animals we*want to initialise
	 *@return An array of animals with names specified in args
	 */
	private static Animal[] initAnimals(String[] args) {
		/* Initialise an array with as its size the number of Strings in the args */
		Animal[] animals =new Animal[args.length];
		/* Use a regular for loop, since we need an index */
		for(int i = 0; i < args.length; i++) {
			String name = args[i];
			/* initialise a new Animal with the name, the energy level is defined in the constructor */
			animals[i] =new Animal(name);
		}
		return animals;
	}
}
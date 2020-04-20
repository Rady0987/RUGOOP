package nl.rug.oop.introduction;
import java.util.Scanner;

public class Main {

    /* Initialises an array of animals hardcoded in the program*/
    private static Animal[] initAnimals() {
        Animal dog = new Animal("Dog", 8);
        Animal ant = new Animal("Ant", 2);
        Animal lion = new Animal("Lion", 600);

        /* Put the animals in an array and return this array */
        Animal[] animals = {dog, ant, lion};
        return animals;
    }

    /* Overloaded method initAnimals*/
    private static Animal[] initAnimals(String[] args) {
        Animal[] animals = new Animal[args.length];
        for (int i = 0; i < args.length; i++) {
            String name = args[i];
            animals[i] = new Animal(name); /* initialise a new Animal with only a name; the energy level is defined in the constructor */
        }
        return animals;
    }

    /* Main method*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Animal[] animals;
        if (args.length == 0) {
            /* No arguments were provided */
            animals = initAnimals();
        } else {
            /* Initialise animals with names given in the command-line arguments */
            animals = initAnimals(args);
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int i = 0; i < animals.length; i++) {
                Animal animal = animals[i];
                if (line.equals("eat")) {
                    /* Calls the eat() method of the object Animal */
                    animal.eat();
                } else if (line.equals("run")) {
                    /* Calls the run() method of the object Animal */
                    animal.run();
                }
                /* Print the hunger level to verify whether something changed */
                animal.printHungerLevel();
            }
        }
    }
}
package nl.rug.oop.rpg;
import nl.rug.oop.rpg.game.Game;
import nl.rug.oop.rpg.game.Player;
import nl.rug.oop.rpg.game.Room;
import nl.rug.oop.rpg.io.Initialiser;

import java.io.IOException;
import java.util.Scanner;

/**
 * The Main class.
 */

public class Main {

	/**
	 * Method that allows to initially start the game or load form saves.
	 * @param game The game that is loaded/started.
	 */
	public static void startGame(Game game) throws IOException, ClassNotFoundException {
		game.playGame(game);
	}

    public static void main(String[] args) throws ClassNotFoundException, IOException {
    	Game game = new Game();
    	Scanner scanner = new Scanner(System.in);
		System.out.println("You are about to start the game, what do you want to do?");
		System.out.println("\t (0) Play Normally");
		System.out.println("\t (1) Initialise from config");
		System.out.println("\t (2) Set default config");
		int num = scanner.nextInt();
    	if (num == 0){
    		Player player = new Player("captain awesome",50,3,0);
    		game.addPlayer(player);
			roomInitialization(game);
			startGame(game);
		}
		else if(num == 1){
			Initialiser.createProperties(game);
			roomInitialization(game);
			System.out.println("\t Initialization from config was successful!");
			startGame(game);
		}
		else if(num == 2){
			Initialiser.initGameFromProperties();
			roomInitialization(game);
			System.out.println("\t Default config set successfully! Restart the game.");
		}
    }

    public static void roomInitialization (Game game){
		 Room room0 = new Room("a rather dusty room full with computers and two doors.");
		 game.addRoom0(room0);
		 Room room1 = new Room("The Chamber of the Dark Trolls.");
		 game.addRoom1(room1);
		 Room room2 = new Room("Zexulia Mechanical Empire.");
		 game.addRoom2(room2);
		 Room room3 = new Room("The Land of Eleven Minotaurs.");
		 game.addRoom3(room3);
		 Room room4 = new Room("The Kingdom of Wisdom.");
		 game.addRoom4(room4);
		 Room room5 = new Room("The Vault of Death.");
		 game.addRoom5(room5);
		 Room room6 = new Room("The Sanctum dimension.");
		 game.addRoom6(room6);
		 Room room7 = new Room("The Hell Incarnate Coliseum.");
		 game.addRoom7(room7);
	 }


}
package nl.rug.oop.rpg;
import nl.rug.oop.rpg.game.Game;
import nl.rug.oop.rpg.game.Player;
import nl.rug.oop.rpg.game.Room;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {

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
			FileSaving file = new FileSaving("savedgames", game);
			game.theSaveLocation(file);
			game.playGame();
		}
		else if(num == 1){
			
		}
		else if(num == 2){
			File saveDirectory = new File("config");
			saveDirectory.mkdir();
			Properties rpgProperties = new Properties();
			rpgProperties.setProperty("playerName", "Howard the Duck");
			rpgProperties.store(new FileOutputStream(new File("config")), "These are the properties of a player in the RPG game");
		}
    }
}
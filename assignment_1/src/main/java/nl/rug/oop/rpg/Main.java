package nl.rug.oop.rpg;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException{
    	Game game = new Game();
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
}
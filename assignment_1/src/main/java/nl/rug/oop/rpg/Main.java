package nl.rug.oop.rpg;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Game game = new Game();
    	Player player = new Player("captain awesome",10,3);
    	game.addPlayer(player);
    	Room room0 = new Room("A rather dusty room full with computers and two doors");
    	game.addRoom0(room0);
		Room room1 = new Room("The chamber of the Dark Trolls");
		game.addRoom1(room1);
		Room room2 = new Room("Zexulia mechanical empire");
		game.addRoom2(room2);
		Room room3 = new Room("The land of eleven minotaurs");
		game.addRoom3(room3);
		Room room4 = new Room("The kingdom of wisdom ");
		game.addRoom4(room4);
		Room room5 = new Room("The vault of death");
		game.addRoom5(room5);
		Room room6 = new Room("The Sanctum dimension");
		game.addRoom6(room6);
		Room room7 = new Room("The Hell Incarnate Coliseum");
		game.addRoom7(room7);
  		game.playGame();
    }
}
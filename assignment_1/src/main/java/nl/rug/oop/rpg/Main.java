package nl.rug.oop.rpg;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Game game = new Game();
    	Player player = new Player("captain awesome",10,3);
    	game.addPlayer(player);
    	Room room0 = new Room("A rather dusty room full with computers and two doors");
    	game.addRoom(room0);
		Room room1 = new Room("A dark room with dark doors");
		game.addRoom(room1);
  		game.playGame();
    }
}
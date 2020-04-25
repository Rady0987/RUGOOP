package nl.rug.oop.rpg;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Game game = new Game();
    	Player player = new Player("captain awesome");
    	game.addPlayer(player);
    	Room room = new Room("A rather dusty room full with computers and two doors");
    	game.addRoom(room);
  		game.playGame();
    }
}
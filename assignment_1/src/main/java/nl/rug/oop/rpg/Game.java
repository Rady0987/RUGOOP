package nl.rug.oop.rpg;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/*
 * The game itself 
 */
public class Game {
	private Player player;
	private ArrayList<Room> rooms;

	public Game() {
		rooms = new ArrayList<>();
	}

	public void addRoom(Room room){
		Door door1 = new Door("A mysterious red door");
    	room.addDoor(door1);
    	Door door2 = new Door("A black door");
    	room.addDoor(door2);
		rooms.add(room);
	}

	public void addPlayer(Player player){
		this.player= player;
	}

	public void playGame(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("What do you want to do?");
    	System.out.println("(0) Look around");
    	System.out.println("(1) Look for a way out");
    	while(scanner.hasNextLine()) {
			String input = scanner.nextLine();
			if(input.equals("0")){
				lookAround();
			}
			if(input.equals("1")){
				lookForWayOut();
			}
			System.out.println("What do you want to do?");
    		System.out.println("(0) Look around");
    		System.out.println("(1) Look for a way out");	
		}
	}

	public void lookAround(){
		System.out.print("You see: ");
		rooms.get(player.location()).inspect();
	}

	public void lookForWayOut(){
		System.out.println("You look around for doors. You see:");
		rooms.get(player.location()).inspectDoors();
	}
	
}